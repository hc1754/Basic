package com.gideon.bims_oxy.app.bis.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gideon.bims_oxy.app.bis.model.BusPositionInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.RouteInfo;
import com.gideon.bims_oxy.app.bis.model.RoutePositionInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

@Repository("busRouteDao")
public class BusRouteDaoImpl implements BusRouteDao {
	
	private static final Logger logger = LoggerFactory.getLogger(BusRouteDaoImpl.class);

	@Autowired
    private SqlSession sqlSession;
  
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public List<RouteInfo> selectBusRouteHistory(BusParamModel param) {
		return sqlSession.selectList("app.bis.busRouteMapper.selectBusRouteHistory", param);
	}

	@Override
	public List<RouteInfo> searchBusRoute(BusParamModel param) {
		List<RouteInfo> resultList = sqlSession.selectList("app.bis.busRouteMapper.searchBusRoute", param);
		
		System.out.println("[DEBUG] searchBusRoute getRouteNumber ::: " + param.getRouteNumber());
		
		if(StringUtils.isNotEmpty(param.getRouteNumber())) {
			for(RouteInfo info : resultList) {
				try {
					param.setRouteId(info.getRouteId());
					sqlSession.insert("app.bis.busRouteMapper.insertBusRouteHistory", param);
				} catch(Exception ex) {
					logger.error("[ERROR] BusRouteDaoImpl.searchBusRoute insertBusRouteHistory :: " + ex.getMessage());
					continue;
				}
			}
		}
		
		return resultList;
	}

	@Override
	public int deleteBusRouteHistory(BusParamModel param) {
		return sqlSession.delete("app.bis.busRouteMapper.deleteBusRouteHistory", param);
	}

	@Override
	public RouteInfo selectRouteOperation(BusParamModel param) {
		return sqlSession.selectOne("app.bis.busRouteMapper.selectRouteOperation", param);
	}

	@Override
	public List<BusPositionInfo> selectRouteBusPositionList(BusParamModel param) {
		return sqlSession.selectList("app.bis.busRouteMapper.selectRouteBusPositionList", param);
	}

	@Override
	public List<BusStopInfo> selectBusStopList(BusParamModel param) {
		return sqlSession.selectList("app.bis.busRouteMapper.selectBusStopList", param);
	}

	@Override
	public List<RouteInfo> selectPassByRoute(BusParamModel param) {
		return sqlSession.selectList("app.bis.busRouteMapper.selectPassByRoute", param);
	}

	@Override
	public List<RoutePositionInfo> selectRoutePosition(BusParamModel param) {
		return sqlSession.selectList("app.bis.busRouteMapper.selectRoutePosition", param);
	}
}
