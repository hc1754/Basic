package com.gideon.bims_oxy.common.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gideon.bims_oxy.common.model.I18nDtl;

@Repository("I18nDtlDao")
public class I18nDtlDaoImpl implements I18nDtlDao{

	@Autowired
    private SqlSession sqlSession;
 
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    
	@Override
	public I18nDtl selectById(HashMap<String, Object> hMap) {
		return sqlSession.selectOne("I18nDtlMapper.selectById", hMap);
	}
}
