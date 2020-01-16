package com.gideon.bims_oxy.app.pay.controller;
import com.gideon.bims_oxy.app.pay.model.QrChrgDAO;
import com.gideon.bims_oxy.app.pay.model.QrMultiLangDAO;
import com.gideon.bims_oxy.app.pay.model.QrUserDAO;
import com.gideon.bims_oxy.app.pay.vo.QrAssistVO;
import com.gideon.bims_oxy.common.support.MessageSource;
import io.opencensus.tags.InternalUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Controller
public class QrUserController {
    @Autowired
    MessageSource messageSource;
    @Autowired
    private QrChrgDAO qrChrgDAO;
    @Autowired
    private QrUserDAO userDAO;
    @Autowired
    private QrMultiLangDAO qrMultiLangDAO;
    @Value("${assistLogin}")
    private String assistLogin;
    @Value("${assistPassword}")
    private String assistPassword;
    @Value("${assistMerchantid}")
    private String assistMerchantid; //상점아이디
    @RequestMapping(value = "/pay", method = RequestMethod.GET, produces = "application/json")

    public String index(@RequestParam HashMap params,ModelMap model) throws Exception {
        List<Map<String, Object>> userList = null;
        Map<String, String> param = new HashMap<String, String>();
        try{
//            param.put("USR_ID","") //사용자조회시 사용
            userList = userDAO.getUserList(params);
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("userList", userList);

        return "pay/index";
    }
    @RequestMapping(value = "/api/pay/multilanglist", method = RequestMethod.GET, produces = "application/json")

    public String multiLangList(@RequestParam HashMap params,ModelMap model) throws Exception {
        List<Map<String, Object>> multiLangList = null;
        Map<String, String> param = new HashMap<String, String>();
        try{
//            param.put("USR_ID","") //사용자조회시 사용
            multiLangList = qrMultiLangDAO.multiLangList(params);
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("multiLangList", multiLangList);

        return "pay/multilanglist";
    }

    @RequestMapping(value = "/api/pay/indexRu", method = RequestMethod.GET, produces = "application/json")

    public String indexRu(@RequestParam HashMap params,ModelMap model) throws Exception {
//        List<Map<String, Object>> multiLangList = null;
//        Map<String, String> param = new HashMap<String, String>();

//        model.addAttribute("multiLangList", multiLangList);

        return "pay/indexRu";
    }

    @RequestMapping(value = "/api/assist/order")

    public String assistOrder(@RequestParam HashMap params,ModelMap model,QrAssistVO qrAssistVO) throws Exception {
//        List<Map<String, Object>> multiLangList = null;
//        Map<String, String> param = new HashMap<String, String>();

//        model.addAttribute("multiLangList", multiLangList);
        List<Map<String, Object>> userList = null;
        String OrderNumber="";
        String giftOrderNumber="";
        try{
//            param.put("USR_ID","") //사용자조회시 사용
            //chargetype를 확인하여 qruseruser
            OrderNumber= userDAO.selectChargeOrderNumber(params);
            userList = userDAO.getUserList(params);
        }catch(Exception e){
            e.printStackTrace();
        }
        qrAssistVO.setCustomerNumber((String)userList.get(0).get("QR_USR_ID"));
        qrAssistVO.setOrderNumber(OrderNumber);
        qrAssistVO.setMerchant_ID(assistMerchantid);
        qrAssistVO.setAssistLogin(assistLogin);
        qrAssistVO.setAssistPassword(assistPassword);
        qrAssistVO.setChargedate((String)params.get("chargedate"));
        qrAssistVO.setChargefee((String)params.get("chargefee"));
        qrAssistVO.setFcmtoken((String)params.get("fcmtoken"));
        qrAssistVO.setTargetfcmtoken((String)params.get("targetfcmtoken"));
        qrAssistVO.setTargetuserid((String)params.get("targetuserid"));
        qrAssistVO.setDelay("0");
        qrAssistVO.setCardPayment("1");


        if(StringUtils.isEmpty(params.get("Language"))){
            qrAssistVO.setLanguage("RU");
            params.put("Language","RU");
        }else{
            qrAssistVO.setLanguage((String)params.get("Language"));
        }

        qrAssistVO.setWMPayment("0");
        qrAssistVO.setYMPayment("0");
        qrAssistVO.setOrderComment((String)params.get("chargetype"));
        qrAssistVO.setOrderCurrency("RUB");
        qrAssistVO.setOrderAmount((String)params.get("chargeamt"));
        qrAssistVO.setFirstname((String)userList.get(0).get("FMLY_NM"));
        qrAssistVO.setLastname((String)userList.get(0).get("NM"));
        qrAssistVO.setEmail((String)userList.get(0).get("QR_USR_EMAIL"));
        qrAssistVO.setSignature(assistMerchantid+";"+OrderNumber+";"+(String)params.get("chargeamt")+";"+qrAssistVO.getOrderCurrency()+";"+(String)userList.get(0).get("QR_USR_ID"));
        //assistMerchantid+";"+OrderNumber+";"+(String)params.get("chargeamt")+";"+qrAssistVO.OrderCurrency+";"+(String)userList.get(0).get("QR_USR_ID")
        model.addAttribute("assistOrderObject", qrAssistVO);


        params.put("qrUsrId",(String)userList.get(0).get("QR_USR_ID"));
        params.put("areaCd","01");

//        params.put("cardNo","");
//        params.put("cardVldtPrid",);
//        params.put("cardCvc",);
        params.put("chrgType","1");
        params.put("chrgDiv","2");
        params.put("chrgAmt",params.get("chargeamt"));
        params.put("chrgFee",params.get("chargefee"));
        params.put("chrgDt",params.get("chargedate"));


        if(params.get("chargetype").equals("CHRG")){
            qrChrgDAO.insertQrChrgOrder(params);
        }
        if(params.get("chargetype").equals("GIFT")){
            params.put("qrUsrId",params.get("userid"));
            params.put("tgtQrUsrId",params.get("targetuserid"));
            params.put("tgtMblDevcId",params.get("targetfcmtoken"));
            params.put("mblDevcId",params.get("fcmtoken"));
            params.put("chrgType","1");
            qrChrgDAO.insertQrGiftOrder(params);
        }

        return "assist/order";
    }

    @RequestMapping(value = "/api/assist/result")

    public String assistResult(@RequestParam HashMap params, ModelMap model, QrAssistVO qrAssistVO) throws Exception {
        qrAssistVO.setOrderNumber((String)params.get("ordernumber"));
        List<Map<String, String>> orderStateList = doPOST(qrAssistVO); //1.Timeout 2.Declined 3.Canceled 4.Approved  성공

        String orderState=orderStateList.get(0).get("orderstate");
        Integer resultOrderStatusCd = 0;
        if(orderState.equals("Timeout")){
            resultOrderStatusCd=1;
        }
        if(orderState.equals("Declined")){
            resultOrderStatusCd=2;
        }
        if(orderState.equals("Canceled")){
            resultOrderStatusCd=3;
        }
        if(orderState.equals("Approved")){
            resultOrderStatusCd=4;
        }


        Map<String, Object> qrOrderList = null;
        Map<String, Object> qrGiftOrderList = null;
        List<Map<String, Object>> sendUserList =null;
        List<Map<String, Object>> targetUserList =null;
        String deviceId = null;
        String targetDeviceId = null;
        //메세지코드 정의
        String recvGiftMessage;
        String sendUserMessage;
        String giftAmntMsg;
        String sendMsg;
        String pushLang;
        String orderamount=orderStateList.get(0).get("orderamount");
        String ordercurrency = orderStateList.get(0).get("ordercurrency");
        //선물주문이력
        qrGiftOrderList = qrChrgDAO.getGiftDeviceId(params);
        //충전주문이력
        qrOrderList = qrChrgDAO.getDeviceId(params);

        if(StringUtils.isEmpty(qrOrderList)){
            //보내는사람
            params.put("userid",qrGiftOrderList.get("QR_USR_ID"));
            sendUserList =userDAO.getUserList(params);
            //받는사람  정보
            params.put("userid",qrGiftOrderList.get("TGT_QR_USR_ID"));


            String sendUserName= (String)sendUserList.get(0).get("FMLY_NM")+(String)sendUserList.get(0).get("NM");
            pushLang=(String)qrGiftOrderList.get("LANGUAGE");
            recvGiftMessage = messageSource.getMessage("recvGift",pushLang.toLowerCase());//선물도착
            sendUserMessage = messageSource.getMessage("sender",pushLang.toLowerCase());//보낸사람
            giftAmntMsg = messageSource.getMessage("giftAmnt",pushLang.toLowerCase());//선물 금액
            sendMsg = recvGiftMessage + " " + sendUserMessage + " " +sendUserName + " " + giftAmntMsg + " " + orderamount + " "+ordercurrency;
            if(resultOrderStatusCd== 4){
                //서버의 충전내역과 선물내역을 비교해서 구분한다
                qrChrgDAO.insertQrGiftNewOk(params);
                targetDeviceId = (String)qrGiftOrderList.get("TGT_MBL_DEVC_ID");
                deviceId = (String)qrGiftOrderList.get("MBL_DEVC_ID");
                if(qrChrgDAO.updateNewGiftQrCardBal(params) == 0) qrChrgDAO.insertNewGiftQrCardBal(params);
                sendPush(deviceId,"","chargeGift","success","","",orderState);
                sendPush(targetDeviceId,sendMsg,"","",recvGiftMessage,"",orderState);

            }else{

                deviceId = (String)qrGiftOrderList.get("MBL_DEVC_ID");
                sendPush(deviceId,"","chargeGift","fail","","",orderState);
            }
        }else{
            //충전에서조회
            if(resultOrderStatusCd== 4){
                qrChrgDAO.insertQrChrgNewOk(params);
                deviceId = (String)qrOrderList.get("TMP_DEVICE_ID");
                if(qrChrgDAO.updateNewQrCardBal(params) == 0) qrChrgDAO.insertNewQrCardBal(params);
                sendPush(deviceId,"","charge","success","","",orderState);

            }else{

                deviceId = (String)qrOrderList.get("TMP_DEVICE_ID");
                sendPush(deviceId,"","charge","fail","","",orderState);
            }
        }

        return "assist/result";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")

    public String main(@RequestParam HashMap params,ModelMap model,QrAssistVO qrAssistVO) throws Exception {
//        List<Map<String, Object>> multiLangList = null;
//        Map<String, String> param = new HashMap<String, String>();

        return "main/index";
    }


    //    @RequestMapping(value="mobile/sendFCM")
    public String sendPush(String fcmToken,String msg,String type,String status,String title,String targetFcmToken,String assistMsgCd)throws Exception{

//        List<MobileTokenVO> tokenList = fcmService.loadFCMInfoList(vo);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        final String apiKey = "AAAAOSA9vhI:APA91bF-lSU7N4BAhNNaVPnTOG-PzG-ZIo2ADqmIeri0oRvFdvdjekqUKQn01aZlY3E0ERVaHM-sBMvHPo_69gUUe_WLFzPDlo2dd7n_bYycu10F6V3R6vv8n4d1587s2XuJz3ACMrdz";
        URL url = new URL("https://fcm.googleapis.com/fcm/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "key=" + apiKey);

        conn.setDoOutput(true);

        String userId =(String) request.getSession().getAttribute("ssUserId");
        String input =null;
        // 이렇게 보내면 주제를 ALL로 지정해놓은 모든 사람들한테 알림을 날려준다.
//        String input = "{\"notification\" : {\"title\" : \"여기다 제목 넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\"/topics/ALL\"}";

        // 타입 charge, chargeGift, null
        if(type == "charge"){
            input = "{\"to\":\""+fcmToken+"\", \"data\": {\"status\":\""+status+"\",\"type\":\"charge\",\"msgcd\":\""+assistMsgCd+"\"}}";
        }else if(type == "chargeGift"){
            input = "{\"to\":\""+fcmToken+"\", \"data\": {\"status\":\""+status+"\",\"type\":\"gift\",\"msgcd\":\""+assistMsgCd+"\"}}";
        }else{
            input = "{" +
                    "\"notification\" : {\"title\" : \""+title+"\", \"body\" : \""+msg+"\"}, \"to\":\""+fcmToken+"\", \"data\": {\"status\":\"success\",\"type\":\"gift\"}," +
                    "}";
        }

//        String input = "{\"to\":\""+fcmToken+"\", \"data\": {\"status\":\"success\"}}";

        OutputStream os = conn.getOutputStream();

        // 서버에서 날려서 한글 깨지는 사람은 아래처럼  UTF-8로 인코딩해서 날려주자
        os.write(input.getBytes("UTF-8"));
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + input);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // print result
        System.out.println(response.toString());


        return "jsonView";
    }
    public String postAssist(QrAssistVO qrAssistVO)throws Exception{

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        URL url = new URL("https://payments.paysecure.ru/orderstate/orderstate.cfm");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        qrAssistVO.setMerchant_ID(assistMerchantid);
        qrAssistVO.setAssistLogin(assistLogin);
        qrAssistVO.setAssistPassword(assistPassword);
        String input =null;

        input = "{" +
                "\"Merchant_ID\" :\""+qrAssistVO.getMerchant_ID()+"\"," +
                "\"Login\" :\""+qrAssistVO.getAssistLogin()+"\"," +
                "\"Password\" :\""+qrAssistVO.getAssistPassword()+"\"," +
                "\"Ordernumber\" :\"20190406-000007722\"," +
                "\"Startyear\" :\"2019\"," +
                "\"Startmonth\" :\"04\"," +
                "\"Startday\" :\"01\"," +
                "\"Starthour\" :\"00\"," +
                "\"Startmin\" :\"00\"," +
                "\"Endyear\" :\"2019\"," +
                "\"Endmonth\" :\"04\"," +
                "\"Endday\" :\"10\"," +
                "\"Endhour\" :\"00\"," +
                "\"Endmin\" :\"00\"," +
                "\"Format\" :\"4\"," +
                "}";

        OutputStream os = conn.getOutputStream();

        // input 전송시 getBytes 함수를 이용 인코딩설정
        os.write(input.getBytes("UTF-8"));
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + input);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // print result
        System.out.println(response.toString());


        return "";
    }

    private List<Map<String, String>> doPOST(QrAssistVO qrAssistVO) throws Exception {

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(100) // connection pool 적용
                .setMaxConnPerRoute(5) // connection pool 적용
                .build();
        factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
        RestTemplate restTemplate = new RestTemplate(factory);

        //add file
//        LinkedMultiValueMap<String, Object> params = null;
//        params.add("file", new FileSystemResource(file));

        //add array
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://payments.paysecure.ru/orderstate/orderstate.cfm");

        qrAssistVO.setMerchant_ID(assistMerchantid);
        qrAssistVO.setAssistLogin(assistLogin);
        qrAssistVO.setAssistPassword(assistPassword);
        //add some String
        // 지금
//        String nowDD = DateTime.now().toString("yyyy년MM월dd일 HH시mm분ss초");
        String nowYYYY = DateTime.now().toString("yyyy");
        String nowMM = DateTime.now().toString("MM");
        String nowDD = DateTime.now().toString("dd");


        // 지금으로 부터 24시간후
        String fyy = DateTime.now().plusHours(24).toString("yyyy");
        String fmm = DateTime.now().plusHours(24).toString("MM");
        String fdd = DateTime.now().plusHours(24).toString("dd");
        String fhh = DateTime.now().plusHours(24).toString("hh");
        String fmi = DateTime.now().plusHours(24).toString("mm");

        builder.queryParam("Merchant_ID", qrAssistVO.getMerchant_ID());
        builder.queryParam("Login", qrAssistVO.getAssistLogin());
        builder.queryParam("Password", qrAssistVO.getAssistPassword());
        builder.queryParam("Ordernumber", qrAssistVO.getOrderNumber());
        builder.queryParam("Startyear", nowYYYY);
        builder.queryParam("Startmonth", nowMM);
        builder.queryParam("Startday", nowDD);
        builder.queryParam("Starthour", "00");
        builder.queryParam("Startmin", "00");
        builder.queryParam("Endyear", fyy);
        builder.queryParam("Endmonth", fmm);
        builder.queryParam("Endday", fdd);
        builder.queryParam("Endhour", "00");
        builder.queryParam("Endmin", "00");
        builder.queryParam("Format", "3");
        //another staff
        String  result = null;
//        NodeList result = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = null;

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.POST,
                requestEntity,
                String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
//        if (statusCode == HttpStatus.ACCEPTED) {
            result = responseEntity.getBody();
//        }

//        return xmlPerson(result);
        System.out.println("\n doXML: " + result);
        return xmlPerson(result);
    }
    private  List<Map<String, String>> xmlPerson(String xmlObject) throws Exception
    {
        BufferedReader br = null;
        //DocumentBuilderFactory 생성 https://jeong-pro.tistory.com/144
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
//        Map<String,Object> orderResultList= new Map<String,Object>();
        HashMap<String, Object> orderResultList = new HashMap<String, Object>();
        // xml 파싱하기
        InputSource is = new InputSource(new StringReader(xmlObject));
        builder = factory.newDocumentBuilder();
        doc = builder.parse(is);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        String resultNode= null;

        // XPathExpression expr = xpath.compile("/response/body/items/item");
        XPathExpression expr = xpath.compile("//order");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        final List<Map<String, String>> out = new ArrayList<Map<String,String>>();
        int len = (nodeList != null) ? nodeList.getLength() : 0;
        for (int i = 0; i < len; i++) {
            NodeList children = nodeList.item(i).getChildNodes();
            Map<String, String> childMap = new HashMap<String, String>();
            for (int j = 0; j < children.getLength(); j++) {
                Node child = children.item(j);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                    childMap.put(child.getNodeName(), child.getTextContent());
            }
            out.add(childMap);
        }
//        return out;
        return out;
    }
}
