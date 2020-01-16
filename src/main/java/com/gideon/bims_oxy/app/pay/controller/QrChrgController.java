package com.gideon.bims_oxy.app.pay.controller;


import com.gideon.bims_oxy.app.pay.model.QrChrgDAO;
import com.gideon.bims_oxy.app.pay.model.QrUserDAO;
import com.gideon.bims_oxy.common.support.MessageSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QrChrgController {
    @Autowired
    MessageSource messageSource;

    @Autowired
    private QrChrgDAO qrChrgDAO;
    @Autowired
    private QrUserDAO qrUserDAO;
    /**
     * json RequestBody
     * HashMap<String, Object> insertQrChrgOrder(@RequestBody HashMap params)
     */
//    @RequestMapping(value = "/api/pay/qrchrgorder", method = RequestMethod.POST, produces = "application/json")
//    public HashMap<String, Object> insertQrChrgOrder(@RequestParam HashMap params) {
//        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        resultMap.put("status","success");
//        List<Map<String, Object>> userData = null;
//        try{
//            qrChrgDAO.insertQrChrgOrder(params);
////pg
//        }catch (Exception e){
//            e.printStackTrace();
//            resultMap.put("status","fail");
//            resultMap.put("msgcd",1);
//        }
//        try{
//            params.put("userid",params.get("qrUsrId"));
//            userData =qrUserDAO.getUserList(params);
//            //PG 연동 후
//            //결재완료 저장후
//            qrChrgDAO.insertQrChrgOk(params);
//            //잔액업데이트 merge 불가로 수정
//            params.put("amtQrUsrId",params.get("qrUsrId"));
//            if(qrChrgDAO.updateQrCardBal(params) == 0) qrChrgDAO.insertQrCardBal(params);
//            // 메세징처리
//            //충전완료
//            String msgSuccessCharg = messageSource.getMessage("B100.C0","en");
//            //충전금액
//            String msgChargAmt =  messageSource.getMessage("rchrgAmnt","en");
////            String msg = (String)userData.get(0).get("FMLY_NM")+(String)userData.get(0).get("NM")+ (String)params.get("chrgAmt")+" P "+msgSuccessCharg;
//            String msg = msgChargAmt+" "+ (String)params.get("chrgAmt")+" P ";
////            sendPush((String)params.get("tgtMblDevcId"),msg,"charge","success");
//            //Exception 처리
////            sendPush((String)params.get("tgtMblDevcId"),msg,"charge","success",msgSuccessCharg);
//        }catch (Exception e){
//            e.printStackTrace();
//            resultMap.put("status","fail");
//            resultMap.put("msgcd",41);
//        }
//
//
//        return resultMap;
//    }
//
//    @RequestMapping(value = "/api/pay/qrgiftorder", method = RequestMethod.POST, produces = "application/json")
//    public HashMap<String, Object> insertQrGiftOrder(@RequestParam HashMap params) {
//        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        resultMap.put("status","success");
//        List<Map<String, Object>> sendUserData = null;
//        List<Map<String, Object>> targetUserData = null;
//        try{
//            qrChrgDAO.insertQrGiftOrder(params);
//        }catch (Exception e){
//            e.printStackTrace();
//            resultMap.put("status","fail");
//            resultMap.put("msgcd",1);
//        }
//        try{
//            params.put("userid",params.get("qrUsrId"));
//            sendUserData =qrUserDAO.getUserList(params);
//            params.put("userid",params.get("tgtQrUsrId"));
//            targetUserData=qrUserDAO.getUserList(params);
//
//            //PG 연동 후
//            //결재완료 저장후
//            qrChrgDAO.insertQrGiftOk(params);
//            //잔액업데이트 선물은 선물 대상자
//            //잔액업데이트 merge 불가로 수정
//            params.put("amtQrUsrId",params.get("qrUsrId"));
//            if(qrChrgDAO.updateQrCardBal(params) == 0) qrChrgDAO.insertQrCardBal(params);
//
////            params.put("tgtMblDevcId","c35RIC8iVtI:APA91bHITMbhQnJCDyQ7pxWomxhJ64ZNWZP-PiacMAqFibS9jhy1kDR4pMh66RrCFV2q1uHDOtF1k_PuKrU3emv8MaT2tt8640FboxW2VxaP1GWEuaEZ6AyAYktJph9bDKXg8NC_5XoA");
////            fVBz2k5F8_E:APA91bFuykd_1KIEe_tK6BwHrfcHO4g0MNSIpVey63XGftHgq5izR8AwlIo1lRYOMEb917FFzzXTtd1s6D5v-fUlXF_1vbLNIDe6qCZzF3JiPp6vgTPpoJZao_Fmn8nma8ghnuJ9aDqv
//            String recvGiftMsg = messageSource.getMessage("recvGift","ru");
//            String msgGiftAmnt =  messageSource.getMessage("giftAmnt","ru");
//            String sendUserName = (String)sendUserData.get(0).get("FMLY_NM")+(String)sendUserData.get(0).get("NM");
//            String targetUserName= (String)targetUserData.get(0).get("FMLY_NM")+(String)targetUserData.get(0).get("NM");
//            String msg =params.get("chrgAmt")+" P from :  "+sendUserName;
////            실패
////            sendPush((String)params.get("tgtMblDevcId"),msg,"charge","success");
////            sendPush((String)params.get("sendMblDevcId"),msg,"chargeGift","success","");
////            sendPush((String)params.get("tgtMblDevcId"),msg,"gift","success",recvGiftMsg);
//        }catch (Exception e){
//            e.printStackTrace();
//            resultMap.put("status","fail");
//            resultMap.put("msgcd",41);
//        }
//
//
//        return resultMap;
//    }


}
