package com.gideon.bims_oxy.app.bis.dao;

import java.util.List;

import com.gideon.bims_oxy.app.bis.model.BusPositionInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.RouteInfo;
import com.gideon.bims_oxy.app.bis.model.RoutePositionInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

public interface BusRouteDao {

    /**
     * 
     * @param  TradeInfo
     * @return List<RouteInfo>
     */    
    public List<RouteInfo> selectBusRouteHistory(BusParamModel param);
    
    /**
     * 
     * @param  BusParamModel 
     * @return List<RouteInfo>
     */    
    public List<RouteInfo> searchBusRoute(BusParamModel param); 
    
    /**
     * 
     * @param  BusParamModel
     * @return int
     */    
    public int deleteBusRouteHistory(BusParamModel param);    
    
    /**
     * 
     * @param  BusParamModel
     * @return List<BusStopInfo>
     */    
    public List<BusStopInfo> selectBusStopList(BusParamModel param);     
    
    /**
     * 
     * @param  BusParamModel
     * @return List<BusPositionInfo>
     */    
    public List<BusPositionInfo> selectRouteBusPositionList(BusParamModel param);     

    /**
     * 
     * @param  BusParamModel
     * @return RouteInfo
     */    
    public RouteInfo selectRouteOperation(BusParamModel param);   
    
    /**
     * 
     * @param  BusParamModel
     * @return List<RouteInfo>
     */    
    public  List<RouteInfo> selectPassByRoute(BusParamModel param);
    
    /**
     * 
     * @param  BusParamModel
     * @return List<RoutePositionInfo>
     */    
    public  List<RoutePositionInfo> selectRoutePosition(BusParamModel param);     
}
