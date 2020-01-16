package com.gideon.bims_oxy.app.pay.controller;

import com.gideon.bims_oxy.app.pay.model.QrMultiLangDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QrMultiLangController {
    @Autowired
    private QrMultiLangDAO qrMultiLangDAO;

    @RequestMapping(value = "/api/pay/insertlangitem", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> insertLangItem(@RequestParam HashMap params){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        Integer updateProcc=0;

        try {
//            T:타이틀, E:표출내용, C:코드

            qrMultiLangDAO.insertLangItem(params);
            resultMap.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 0);
        }
        return resultMap;
    }

    @RequestMapping(value = "/api/pay/updatelangitem", method = RequestMethod.POST, produces = "application/json")
    public HashMap<String, Object> updateLangItem(@RequestParam HashMap params){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();


        try {
//            T:타이틀, E:표출내용, C:코드

            qrMultiLangDAO.updateLangItem(params);
            resultMap.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "fail");
            resultMap.put("msgcd", 0);
        }
        return resultMap;
    }

}
