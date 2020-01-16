package com.gideon.bims_oxy.app.pay.controller;

import com.gideon.bims_oxy.app.pay.model.*;
import com.gideon.bims_oxy.app.pay.vo.QrUserVO;
import com.gideon.bims_oxy.common.support.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.util.*;


@RestController
public class QrRestController {
    @Value("${setHost}")
    private String setHost;
    @Value("${setPort}")
    private Integer setPort;
    @Value("${setUsername}")
    private String setUsername;
    @Value("${setPassword}")
    private String setPassword;
    @Value("${mailTransportProtocol}")
    private String mailTransportProtocol;
    @Value("${mailSmtpAuth}")
    private String mailSmtpAuth;
    @Value("${mailSmtpStarttlsEnable}")
    private String mailSmtpStarttlsEnable;
    @Value("${mailDebug}")
    private String mailDebug;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(setHost);
        mailSender.setPort(setPort);
        //추후 config context 와 properties 추가
        mailSender.setUsername(setUsername);
        mailSender.setPassword(setPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mailTransportProtocol);
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.starttls.enable", mailSmtpStarttlsEnable);
        props.put("mail.debug", mailDebug);

        return mailSender;
    }

    @Autowired
    private QrUserDAO userDAO;
    @Autowired
    public JavaMailSender emailSender;
//    private JavaMailSender mailSender;

    public void setMailSender(JavaMailSender mailSender) {
        this.emailSender = mailSender;
    }

    @Autowired
    MessageSource messageSource;
    public void sendSimpleMessage(String to, String subject, String text) {

//        SimpleMailMessage message = new SimpleMailMessage();
        MimeMessage message = emailSender.createMimeMessage();
        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            message.setSubject(subject,"UTF-8");
            message.setText(text,"UTF-8","html");
            messageHelper.setFrom(setUsername, "OxyPAY team");
            messageHelper.setTo(new InternetAddress(to,"", "UTF-8"));

            emailSender.send(message);
        }catch (Exception e){

        }
//        message.setTo(to);
//        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
//
//        출처: https://gangzzang.tistory.com/category/Web/Spring [갱짱.study]
//        message.setSubject(subject,"UTF-8");
//        message.setText(text);
//        emailSender.send(message);
    }

    public StringBuffer shaEncrypt(String password) {

        StringBuffer hexString = new StringBuffer();
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));


            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return hexString;
    }

    /**
     *
     */
    /**
     * 전달된 파라미터에 맞게 난수를 생성한다
     * @param len : 생성할 난수의 길이
     * @param dupCd : 중복 허용 여부 (1: 중복허용, 2:중복제거)
     *
     * Created by 닢향
     * http://niphyang.tistory.com
     */
    public static String numberGen(int len, int dupCd ) {

        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수

        for(int i=0;i<len;i++) {

            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));

            if(dupCd==1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if(!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i-=1;
                }
            }
        }
        return numStr;
    }
    /**
     * 로그인체크
     */
    @RequestMapping(value = "/api/pay/loginproc", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> loginCheck(@RequestParam HashMap params) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String userId = null;
        String oldDeviceId = null;
        String loginDeviceId = (String)params.get("deviceid");
        List<Map<String, Object>> userData = null;
        try {
            userId = userDAO.loginCheck(params);
            oldDeviceId = userDAO.loginDeviceIdCheck(params);
            userData = userDAO.getUserList(params);

            if(userId==null || userId==""){ //아이디 패스워드 불일치
                resultMap.put("status", "fail");
                resultMap.put("msgcd", 1);
            }else{
                if(oldDeviceId.equals("2")){ //디바이스 아이디 없음
                    resultMap.put("status", "fail");
                    resultMap.put("msgcd", 2);
                }else{
                    if(loginDeviceId.equals(oldDeviceId)){//디바이스 아이디가 로그인한 사용자의 디바이스 아이디와 일치하는경우
                        resultMap.put("status", "success");
                        resultMap.put("firstname",(String)userData.get(0).get("FMLY_NM"));
                        resultMap.put("lastname",(String)userData.get(0).get("NM"));
                        resultMap.put("gender",(String)userData.get(0).get("GNDR"));
                        resultMap.put("birth",userData.get(0).get("BIRTH"));
                        resultMap.put("balance",userData.get(0).get("BALANCE"));
                        resultMap.put("phone",userData.get(0).get("TMP_PHONE"));
                        resultMap.put("lastchargedate",userData.get(0).get("LASTCHARGEDATE"));
                        resultMap.put("email",(String)userData.get(0).get("QR_USR_EMAIL"));
                        resultMap.put("deviceid",(String)userData.get(0).get("TMP_QR_DEVICE_ID"));
                        //마지막충전 시간
                        //마지만 선물 받은시간
                    }else {
                        resultMap.put("status", "fail");
                        resultMap.put("msgcd", 3);
                        resultMap.put("deviceid ",oldDeviceId);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "fail");
            resultMap.put("msgcd",41);
        }
        return resultMap;
    }
    /**
     *
     */
    @RequestMapping(value = "/api/pay/changedevice", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> changePhone(@RequestParam HashMap params){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<Map<String, Object>> userData = null;
        try{
            userDAO.updateDevice(params);
            userData = userDAO.getUserList(params);
            resultMap.put("status","success");
            resultMap.put("firstname",(String)userData.get(0).get("FMLY_NM"));
            resultMap.put("lastname",(String)userData.get(0).get("NM"));
            resultMap.put("gender",(String)userData.get(0).get("GNDR"));
            resultMap.put("birth",userData.get(0).get("BIRTH"));
            resultMap.put("balance",userData.get(0).get("BALANCE"));
            resultMap.put("phone",userData.get(0).get("TMP_PHONE"));
            resultMap.put("lastchargedate",userData.get(0).get("LASTCHARGEDATE"));
            resultMap.put("email",(String)userData.get(0).get("QR_USR_EMAIL"));
            resultMap.put("deviceid",(String)userData.get(0).get("TMP_QR_DEVICE_ID"));
        }catch (Exception e){
            resultMap.put("status","fail");
            resultMap.put("msgcd",41);
//            resultMap.put("status",e.getCause());
        }
        return resultMap;
    }
    //아이디 찾기 가입시 중복체크
    @RequestMapping(value = "/api/pay/findid", method = RequestMethod.GET, produces = "application/json")
    public HashMap<String, Object> findId(@RequestParam HashMap params) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<QrUserVO> userData = null;
        try {
            userData= userDAO.findId(params);
            if(userData.size() > 0) {
//            send email
//                sendSimpleMessage(userData.get(0).getUsrEmail(), subject, userData.get(0).getUsrId());
                resultMap.put("email", userData.get(0).getEmail());
                resultMap.put("phone", userData.get(0).getPhone());
                resultMap.put("status", "success");
            }else{
                resultMap.put("status", "fail");
                resultMap.put("msgcd",1);
            }

        } catch (Exception e) {
//            e.printStackTrace();
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 41);
        }
        return resultMap;
    }
    //아이디 찾기 이메일
    @RequestMapping(value = "/api/pay/findidbyemail", method = RequestMethod.GET, produces = "application/json")
    public HashMap<String, Object> findIdByEmail(@RequestParam HashMap params) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        String email = (String) params.get("email");
        List<Map<String, Object>> userData = null;

        try {
            userData= userDAO.getIdList(params);
            if(userData.size() > 0){
                resultMap.put("ids",userData);
                resultMap.put("status", "success");
            }else{
                resultMap.put("status", "fail");
                resultMap.put("msgcd", 1);
            }

        } catch (Exception e) {
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 41);
        }
        return resultMap;
    }
    //아이디 찾기 폰번호
    @RequestMapping(value = "/api/pay/findidbyphone", method = RequestMethod.GET, produces = "application/json")
    public HashMap<String, Object> findIdByPhone(@RequestParam HashMap params) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        String email = (String) params.get("email");
        List<Map<String, Object>> userData = null;
        try {
            userData= userDAO.getIdList(params);
            if(userData.size() > 0){
                resultMap.put("ids",userData);
                resultMap.put("status", "success");
            }else{
                resultMap.put("status", "fail");
                resultMap.put("msgcd", 1);
            }


        } catch (Exception e) {
//            e.printStackTrace();
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 41);
        }
        return resultMap;
    }
    //비밀번호 초기화
    @RequestMapping(value = "/api/pay/resetpassword", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> resetPassword(@RequestParam HashMap params) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String subject =  messageSource.getMessage("pwResetSendMailTitle",(String)params.get("langcd"));//비밀번호초기화 타이틀
        String memo = messageSource.getMessage("pwResetSendMailContent",(String)params.get("langcd"));//비밀번호초기화 내용
        Boolean idCheck = joinIdCheck(params);
        List<QrUserVO> userData = null;
//        Boolean emailCheck = joinEmailCheck(params);
//        String email = (String) params.get("email");
        String basePassword = numberGen(4,1);
        //패스워드암호화
        StringBuffer encryptSha = shaEncrypt(basePassword);

        //sha256
         params.put("password", encryptSha.toString());
        //확인용
//        params.put("basePassword", randomValue);
//        params.put("sha250encrypt", encryptSha);

        try {
            userData = userDAO.findId(params);
            if (!idCheck) {
                //                사용자에게는 암호화전에 비번을 보낸다
                sendSimpleMessage(userData.get(0).getEmail(), subject, memo+" : "+basePassword);
                userDAO.updatePassword(params);
                resultMap.put("status", "success");
            } else {
//                if (emailCheck) resultMap.put("msg", "email check fail");
                if (idCheck) resultMap.put("msgcd", "1");
                resultMap.put("status", "fail");
            }
        } catch (Exception e) {
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 41);
        }
        return resultMap;
    }

    //이메일 인증
    @RequestMapping(value = "/api/pay/authemail", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> authEmail(@RequestParam HashMap params) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String memo;
        String subject =  messageSource.getMessage("authSendMailTitle",(String)params.get("langcd"));//
        memo = messageSource.getMessage("atuhSendMailContent",(String)params.get("langcd"));//
        String email = (String)params.get("email");
        String basePassword = numberGen(4,1);
        List<Map<String, Object>> userData = null;

        try {
            if(email == null){
                userData= userDAO.getUserList(params);
                email = (String)userData.get(0).get("QR_USR_EMAIL");
                memo =  messageSource.getMessage("atuhSendMailRestPasswordContent",(String)params.get("langcd"));
            }

            sendSimpleMessage(email, subject, memo+" : "+basePassword);
            resultMap.put("status", "success");
            resultMap.put("emailAuthCode", basePassword);

        } catch (Exception e) {
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 41);
        }
        return resultMap;
    }
    //비밀번호 변경
    @RequestMapping(value = "/api/pay/changepassword", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> changePassword(@RequestParam HashMap params){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String idCheck = null;

        try {
            idCheck = userDAO.loginCheck(params);
            if(idCheck != null) {
                params.put("password", (String) params.get("newpassword"));
                userDAO.updatePassword(params);
                resultMap.put("status", "success");
            }else{
                resultMap.put("msgcd", 1);
                resultMap.put("status", "fail");
            }
        } catch (Exception e) {
            resultMap.put("msgcd", 41);
            resultMap.put("status", "fail");
        }

        return resultMap;
    }

    //회원정보변경
    @RequestMapping(value = "/api/pay/changeuserinfo", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> changeUserInfo(@RequestParam HashMap params){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        Integer updateProcc=0;
        params.put("birth", (String)params.get("birth"));
        try {
            updateProcc = userDAO.updateUserInfo(params);
            if (updateProcc ==0){
                resultMap.put("msgcd", 1);
                resultMap.put("status", "fail");
            }else {
                resultMap.put("status", "success");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 41);
        }
        return resultMap;
    }

    //회원가입시 이메일중복체크
    @RequestMapping(value = "/joinEmailCheck")
    public Boolean joinEmailCheck(@RequestParam HashMap params) {
        Boolean emailCheck = false;
        String email = (String) params.get("email");
//        중복체크 시 값이 있으면 true
        try {
            if (userDAO.joinEmailCheck(email) == 0) {
                emailCheck = true;
            } else {
                emailCheck = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emailCheck;
    }

    //회원가입시 아이디중복체크
    @RequestMapping(value = "/joinIdCheck")
    public Boolean joinIdCheck(@RequestParam HashMap params) {
        Boolean useridCheck = false;
        String userId = (String) params.get("userid");
        try {
            if (userDAO.joinIdcheck(userId) == 0) {
                useridCheck = true;
            } else {
                useridCheck = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return useridCheck;
    }

    //회원가입처리
    @RequestMapping(value = "/api/pay/joinproc", method = RequestMethod.POST, produces = "application/json")

    public HashMap<String, Object> joinInsert(@RequestParam HashMap params) {

        params.put("birth", (String)params.get("birth"));
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        Boolean idCheck = joinIdCheck(params);
        try {
            if (idCheck) {
                userDAO.insertUser(params);
                resultMap.put("status", "success");
            } else {
                resultMap.put("status", "fail");
                if (!idCheck) resultMap.put("msgcd", 1);

            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 41);
            resultMap.put("msg", e.getCause());
        }
        return resultMap;
    }

    //탈퇴시 업데이트
    @RequestMapping(value = "/api/pay/updateuser", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> updateUser(@RequestParam HashMap params) {
        Integer test = 0;
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        try {
            test= userDAO.updateUser(params);
            if(test > 0 ){
                resultMap.put("status","success");
            }else {
                resultMap.put("status","fail");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }


    //지불이력조회
    @RequestMapping(value ="/api/pay/qrusehistory", method = RequestMethod.GET, produces = "application/json")
    public HashMap<String, Object> qrBusPayHistory(@RequestParam HashMap params){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<Map<String, Object>> userData = null;

        try{
            userData = userDAO.getUserList(params);
            resultMap.put("buspaylist",userDAO.selectBusPayList(params));
            resultMap.put("chrglist",userDAO.selectChrgList(params));
            resultMap.put("getgiftlist",userDAO.selectGetGiftList(params));
            resultMap.put("postgiftlist",userDAO.selectPostGiftList(params));
            resultMap.put("balance",userData.get(0).get("BALANCE"));
            resultMap.put("lastchargedtime",userData.get(0).get("LASTCHARGEDATE"));
            resultMap.put("status","success");
        }catch (Exception e){
            resultMap.put("status","fail");
            resultMap.put("msgcd",41);
        }
        return resultMap;
    }
}
