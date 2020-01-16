package com.gideon.bims_oxy.app.pay.controller;

import com.gideon.bims_oxy.app.pay.model.QrBusPayDAO;
import com.gideon.bims_oxy.app.pay.model.QrUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController

public class QrDcuRestController {
    @Autowired
    private QrBusPayDAO qrBusPayDAO;
    @Autowired
    private QrUserDAO qrUserDAO;
/**
 * QR 지불정보 등록
 */
    @RequestMapping(value = "/api/pay/insertqrpay", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> insertQrPay(@RequestBody HashMap params) {

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        Map<String, Object> tradelist = new HashMap<String, Object>();
//        tradelist.put("tradelist",(List<String>)params.get("tradeList"));
//        List<String> tradeList = null;
        resultMap.put("status","success");
        try{ qrBusPayDAO.insertQrBusPay((List<String>)params.get("tradeList"));
            try{
                qrBusPayDAO.updateQrCardBal((List<String>)params.get("tradeList"));

            }catch (Exception e){
                resultMap.put("status","fail");
                resultMap.put("msgcd",2);
            }
        }catch (Exception e){
            resultMap.put("status","fail");
            resultMap.put("msgcd",1);
        }

        return resultMap;
    }
    @RequestMapping(value = "/api/pay/bllist", method = RequestMethod.GET, produces = "application/json")
    public HashMap<String, Object> qrUserCardInfo(@RequestParam HashMap params) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        try{
            resultMap.put("bllist",qrBusPayDAO.selectBlList(params)) ;
            resultMap.put("status","success");
        }catch (Exception e){
            resultMap.put("status",0);
        }
        return resultMap;
    }
//    @RequestMapping(value = "/userqrcardinfo", method = RequestMethod.POST, produces = "application/json")
//    public HashMap<String, Object> qrUserCardInfo(@RequestParam HashMap params) {
//        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        try{
//            qrUserDAO.selectQrUserCardInfo(params);
//            resultMap.put("status","success");
//        }catch (Exception e){
//            resultMap.put("status",0);
//        }
//        return resultMap;
//    }
}
