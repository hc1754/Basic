package com.gideon.bims_oxy.app.pay.model;

import com.gideon.bims_oxy.app.pay.vo.QrUserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class QrUserDAO {
    @Autowired
    private SqlSession sql;

    public String selectChargeOrderNumber(Map<String,Object> params) throws SQLException{
        String selectChargeOrderNumber= sql.selectOne("app.pay.qrChrgMapper.selectChargeOrderNumber",params);
        return selectChargeOrderNumber;
    }

    public List<Map<String, Object>> getUserList(Map<String, String> params) throws SQLException {
        List<Map<String, Object>> getUserList = sql.selectList("app.pay.qrUserMapper.getUserList",params);
        return getUserList;
    }
    public List<Map<String, Object>> getIdList(Map<String, String> params) throws SQLException {
        List<Map<String, Object>> getIdList = sql.selectList("app.pay.qrUserMapper.getIdList",params);
        return getIdList;
    }
    public String loginCheck(Map<String, String> params) throws SQLException{
        String  loginCheck = (String)sql.selectOne("app.pay.qrUserMapper.loginCheck",params);
        return loginCheck;
    }
    public String loginDeviceIdCheck(Map<String, String> params) throws SQLException{
        String  loginDeviceIdCheck = (String)sql.selectOne("app.pay.qrUserMapper.loginDeviceIdCheck",params);
        return loginDeviceIdCheck;
    }
    public Integer joinEmailCheck(String email) throws SQLException{
        Integer joinEmailCheck = (Integer)sql.selectOne("app.pay.qrUserMapper.joinEmailCheck",email);
        return joinEmailCheck;
    }

    public Integer joinIdcheck(String userid) throws SQLException{
        Integer joinIdChek = (Integer)sql.selectOne("app.pay.qrUserMapper.joinIdCheck",userid);
        return joinIdChek;
    }

    public List<QrUserVO> findId(Map<String, String> params) throws SQLException{
        List<QrUserVO>  findId = sql.selectList("app.pay.qrUserMapper.findId",params);
        return findId;
    }

    public List<String> selectQrUserCardInfo (Map<String,Object> params) throws SQLException{
        List<String> selectQrUserCardInfo = sql.selectList("app.pay.qrUserMapper.selectQrUserCardInfo",params);
        return selectQrUserCardInfo;
    }
    public void insertUser(Map<String, String> params) throws SQLException {
        sql.insert("app.pay.qrUserMapper.insertUser", params);
    }
    public Integer updateUser(Map<String, String> params) throws SQLException {
        Integer updateUser = sql.update("app.pay.qrUserMapper.updateUser", params);
        return updateUser;
    }

    public void updatePassword(Map<String, Object> params) throws SQLException {
        sql.update("app.pay.qrUserMapper.updatePassword", params);
    }
    public Integer updateUserInfo(Map<String,String> params) throws SQLException{
        Integer updateUserInfo= sql.update("app.pay.qrUserMapper.updateUserInfo",params);
        return  updateUserInfo;
    }
    public void updateDevice(Map<String,String> params) throws SQLException{
        sql.update("app.pay.qrUserMapper.updateDevice",params);
    }


    public List<Map<String, Object>> selectBusPayList(HashMap params) throws SQLException {
        List<Map<String, Object>> selectBusPayList =sql.selectList("app.pay.qrUserMapper.selectBusPayList", params);
        return selectBusPayList;
    }
    public List<Map<String, Object>> selectChrgList(HashMap params) throws SQLException {
        List<Map<String, Object>> selectChrgList =sql.selectList("app.pay.qrUserMapper.selectChrgList", params);
        return selectChrgList;
    }
    public List<Map<String, Object>> selectGetGiftList(HashMap params) throws SQLException {
        List<Map<String, Object>> selectGetGiftList =sql.selectList("app.pay.qrUserMapper.selectGetGiftList", params);
        return selectGetGiftList;
    }
    public List<Map<String, Object>> selectPostGiftList(HashMap params) throws SQLException {
        List<Map<String, Object>> selectPostGiftList =sql.selectList("app.pay.qrUserMapper.selectPostGiftList", params);
        return selectPostGiftList;
    }
}
