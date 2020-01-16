package com.gideon.bims_oxy.app.pay.controller;

import com.gideon.bims_oxy.app.pay.model.*;
import com.gideon.bims_oxy.app.pay.vo.ChrgPlcyVO;
import com.gideon.bims_oxy.app.pay.vo.MsgMultilangVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class QrRestConfigController {
    @Autowired
    private QrRestConfigDAO qrRestConfigDAO;
    //multi msg 처리
    @RequestMapping(value = "/api/pay/msgmultilanginfo", method = RequestMethod.GET, produces = "application/json")
    public HashMap<String, Object> msgMultiLangInfo(@RequestParam HashMap params) {
//        List<HashMap<String, String>> msgArray = null;
        List<MsgMultilangVO> msgArray = null;
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        try{
            msgArray= qrRestConfigDAO.selectMsgMultiLangInfo(params);
            if(msgArray.size() > 0){
                resultMap.put("status","success");
                resultMap.put("data",msgArray);
            }else{
                resultMap.put("status","fail");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("status","fail");
            resultMap.put("msgcd",41);
        }
        return resultMap;
    }
    @RequestMapping(value = "/api/pay/chrgplcyinfo", method = RequestMethod.GET, produces = "application/json")
    public  HashMap<String, Object> selectChrgPlcyInfo(){
//        List<ChrgPlcyVO> selectChrgPlcyIist = null;
        List<ChrgPlcyVO> selectChrgPlcyIist = null;
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        try{
            selectChrgPlcyIist = qrRestConfigDAO.selectChrgPlcyInfo();
            if(selectChrgPlcyIist.size()>0){
                resultMap.put("status","success");
                resultMap.put("data",selectChrgPlcyIist);
            }else{
                resultMap.put("status","fail");
            }
        }catch (Exception e){
            resultMap.put("status","fail");
            resultMap.put("msgcd",41);
        }

        return resultMap;
    }
    @RequestMapping(value = "/api/pay/parameters", method = RequestMethod.GET, produces = "application/json")
    public HashMap<String, Object> paraMeters(@RequestParam HashMap params) {

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        Integer fare =0;
        Integer numberofpossiblereleasing =0; //QR_CRT_COUNT_LIMIT
        Integer qrlifetime= 0; //TRCN_PRMT_INFO
        try{
            fare = qrRestConfigDAO.selectQrRestConfig();
            numberofpossiblereleasing = qrRestConfigDAO.qrCrtCountLimit();
            qrlifetime = qrRestConfigDAO.trcnPrmtInfo();
            resultMap.put("fare",fare);
            resultMap.put("qrlifetime",qrlifetime);
            resultMap.put("numberofpossiblereleasing",numberofpossiblereleasing);
            resultMap.put("status","success");

        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("status","fail");
            resultMap.put("msgcd",41);
        }
        return resultMap;
    }

}
