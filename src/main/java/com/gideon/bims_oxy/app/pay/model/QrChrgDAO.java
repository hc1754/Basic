package com.gideon.bims_oxy.app.pay.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@Repository
public class QrChrgDAO {

    @Autowired
    private SqlSession sql;
    public Map<String,Object> getDeviceId(Map<String,Object> params) throws SQLException{
        Map<String,Object> getDeviceId = sql.selectOne("app.pay.qrChrgMapper.getDeviceId", params);
        return getDeviceId;
    }
    public Map<String,Object> getGiftDeviceId(Map<String,Object> params) throws SQLException{
        Map<String,Object> getGiftDeviceId = sql.selectOne("app.pay.qrChrgMapper.getGiftDeviceId", params);
        return getGiftDeviceId;
    }
    public void insertQrChrgOrder(Map<String, String> params) throws SQLException {
        sql.insert("app.pay.qrChrgMapper.insertQrChrgOrder", params);
    }
    public void insertQrGiftOrder(Map<String, String> params) throws SQLException {
        sql.insert("app.pay.qrChrgMapper.insertQrGiftOrder", params);
    }

    public Integer updateNewQrCardBal(Map<String, String> params) throws SQLException {
        Integer updateResult = sql.update("app.pay.qrChrgMapper.updateNewQrCardBal", params);
        return updateResult;
    }

    public void insertNewQrCardBal(Map<String, String> params) throws SQLException {
        sql.insert("app.pay.qrChrgMapper.insertNewQrCardBal", params);
    }


    public Integer updateNewGiftQrCardBal(Map<String, String> params) throws SQLException {
        Integer updateNewGiftQrCardBal = sql.update("app.pay.qrChrgMapper.updateNewGiftQrCardBal", params);
        return updateNewGiftQrCardBal;
    }

    public void insertNewGiftQrCardBal(Map<String, String> params) throws SQLException {
        sql.insert("app.pay.qrChrgMapper.insertNewGiftQrCardBal", params);
    }



    public void insertQrChrgNewOk(Map<String, String> params) throws SQLException {
        sql.insert("app.pay.qrChrgMapper.insertQrChrgNewOk", params);
    }

    public void insertQrGiftNewOk(Map<String, String> params) throws SQLException {
        sql.insert("app.pay.qrChrgMapper.insertQrGiftNewOk", params);
    }







    //    public Integer updateQrCardBal(Map<String, String> params) throws SQLException {
//        Integer updateResult = sql.update("app.pay.qrChrgMapper.updateQrCardBal", params);
//        return updateResult;
//    }
//    public void insertQrCardBal(Map<String, String> params) throws SQLException {
//        sql.insert("app.pay.qrChrgMapper.insertQrCardBal", params);
//    }
//    public void insertQrGiftOk(Map<String, String> params) throws SQLException {
//        sql.insert("app.pay.qrChrgMapper.insertQrGiftOk", params);
//    }
//    public void insertQrChrgOk(Map<String, String> params) throws SQLException {
//        sql.insert("app.pay.qrChrgMapper.insertQrChrgOk", params);
//    }
}
