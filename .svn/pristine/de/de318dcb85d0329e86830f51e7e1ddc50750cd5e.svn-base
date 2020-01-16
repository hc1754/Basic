package com.gideon.bims_oxy.app.pay.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QrMultiLangDAO {

    @Autowired
    private SqlSession sql;
    public void insertLangItem(HashMap params) throws SQLException{
        sql.insert("app.pay.qrMultiLangMapper.insertLangItem",params);
    }
    public void updateLangItem(HashMap params) throws SQLException{
        sql.insert("app.pay.qrMultiLangMapper.updateLangItem",params);
    }
    public List<Map<String, Object>> multiLangList(HashMap params) throws SQLException{
        List<Map<String, Object>> multiLangList = sql.selectList("app.pay.qrMultiLangMapper.multiLangList",params);
        return multiLangList;
    }
}
