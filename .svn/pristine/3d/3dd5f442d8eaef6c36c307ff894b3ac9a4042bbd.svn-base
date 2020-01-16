package com.gideon.bims_oxy.app.bis.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gideon.bims_oxy.app.bis.model.BusArriveInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

@Repository("busStopDao")
public class BusStopDaoImpl implements BusStopDao {
	
	private static final Logger logger = LoggerFactory.getLogger(BusStopDaoImpl.class);

	@Autowired
    private SqlSession sqlSession;
  
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public List<BusStopInfo> selectBusStopHistory(BusParamModel param) {
		return sqlSession.selectList("app.bis.busStopMapper.selectBusStopHistory", param);
	}
	
	@Override
	public int deleteBusStopHistory(BusParamModel param) {
		return sqlSession.delete("app.bis.busStopMapper.deleteBusStopHistory", param);
	}	

	@Override
	public List<BusStopInfo> searchBusStop(BusParamModel param) {
		List<BusStopInfo> resultList = sqlSession.selectList("app.bis.busStopMapper.searchBusStop", param);
		
		if(resultList != null) {
			for(BusStopInfo info : resultList) {
				if(StringUtils.isNotEmpty(info.getBusStopId())) {
					try {
						param.setBusStopId(info.getBusStopId());
						sqlSession.insert("app.bis.busStopMapper.insertBusStopHistory", param);
					} catch(Exception ex) {
						logger.error("[ERROR] BusStopDaoImpl.searchBusStop insertBusStopHistory :: " + ex.getMessage());
						continue;
					}
				}
			}
		}
		
		return resultList;
	}

	@Override
	public List<BusArriveInfo> selectArrivingBusListByBusStop(BusParamModel param) {
		return sqlSession.selectList("app.bis.busStopMapper.selectArrivingBusListByBusStop", param);
	}
	
	@Override
	public List<BusStopInfo> selectBusStopPosition(BusParamModel param) {
		return sqlSession.selectList("app.bis.busStopMapper.selectBusStopPosition", param);
	}

	@Override
	public List<BusStopInfo> selectWithinBusStop(BusParamModel param) {
		return sqlSession.selectList("app.bis.busStopMapper.selectWithinBusStop", param);
	}
}
