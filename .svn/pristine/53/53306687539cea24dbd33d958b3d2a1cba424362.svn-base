package com.gideon.bims_oxy.app.pay.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QrBusPayDAO {
    @Autowired
    private SqlSession sql;

    public void insertQrBusPay(List<String> list) throws SQLException {
        sql.insert("app.pay.qrBusPayMapper.insertQrBusPay", list);
    }
    public void updateQrCardBal(List<String> list) throws SQLException {
        sql.update("app.pay.qrBusPayMapper.updateQrCardBal", list);
    }

    public List<Map<String, Object>> selectBlList(HashMap params) throws SQLException {
        List<Map<String, Object>>selectBlList =sql.selectList("app.pay.qrBusPayMapper.selectBlList", params);
        return selectBlList;
    }
}
