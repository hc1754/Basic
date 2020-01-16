package com.gideon.bims_oxy.app.bis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.FavoriteInfo;
import com.gideon.bims_oxy.app.bis.model.RouteInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

@Repository("mainScreenDao")
public class MainScreenDaoImpl implements MainScreenDao {

	@Autowired
    private SqlSession sqlSession;
  
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public List<FavoriteInfo> selectFavoriteList(BusParamModel param) {
		return sqlSession.selectList("app.bis.mainScreenMapper.selectFavoriteList", param);
	}    

	@Override
	public List<RouteInfo> selectFavoriteRouteList(BusParamModel param) {
		return sqlSession.selectList("app.bis.mainScreenMapper.selectFavoriteRouteList", param);
	}

	@Override
	public List<BusStopInfo> selectFavoriteBusStopList(BusParamModel param) {
		return sqlSession.selectList("app.bis.mainScreenMapper.selectFavoriteBusStopList", param);
	}
	
	@Override
	public List<BusStopInfo> selectFavoriteMultiList(BusParamModel param) {
		return sqlSession.selectList("app.bis.mainScreenMapper.selectFavoriteMultiList", param);
	}	

	@Override
	public Integer insertFavorite(BusParamModel param) {
		return sqlSession.insert("app.bis.mainScreenMapper.insertFavorite", param);
	}

	@Override
	public Integer deleteFavorite(BusParamModel param) {
		return sqlSession.delete("app.bis.mainScreenMapper.deleteFavorite", param);
	}
}
