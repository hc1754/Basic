package com.gideon.bims_oxy.app.bis.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.FavoriteInfo;
import com.gideon.bims_oxy.app.bis.model.RouteInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

@Transactional
public interface MainScreenService {

    /**
     * 
     * @param  BusParamModel
     * @return List<FavoriteInfo>
     */    
    public List<FavoriteInfo> selectFavoriteList(BusParamModel param);

	/**
     * 
     * @param  BusParamModel
     * @return List<RouteInfo>
     */    
    public List<RouteInfo> selectFavoriteRouteList(BusParamModel param);

    /**
     * 
     * @param  BusParamModel
     * @return List<BusStopInfo>
     */    
    public List<BusStopInfo> selectFavoriteBusStopList(BusParamModel param);

    /**
     * 
     * @param  BusParamModel
     * @return List<BusStopInfo>
     */    
    public List<BusStopInfo> selectFavoriteMultiList(BusParamModel param);

    /**
     * 
     * @param  BusParamModel
     * @return String
     */    
    public String editFavorite(BusParamModel param);
}
