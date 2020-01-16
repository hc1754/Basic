package com.gideon.bims_oxy.app.bis.dao;

import java.util.List;

import com.gideon.bims_oxy.app.bis.model.BusArriveInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

public interface BusStopDao {

    /**
     * 
     * @param  BusParamModel
     * @return List<BusStopInfo>
     */    
    public List<BusStopInfo> selectBusStopHistory(BusParamModel param);
    
    /**
     * 
     * @param  BusParamModel
     * @return int
     */    
    public int deleteBusStopHistory(BusParamModel param);   

    /**
     * 
     * @param  BusParamModel
     * @return List<BusStopInfo>
     */    
    public List<BusStopInfo> searchBusStop(BusParamModel param); 
    
    /**
     * 
     * @param  BusParamModel
     * @return List<BusArriveInfo>
     */    
    public List<BusArriveInfo> selectArrivingBusListByBusStop(BusParamModel param);     
    
    /**
     * 
     * @param  BusParamModel
     * @return List<BusStopInfo>
     */    
    public List<BusStopInfo> selectBusStopPosition(BusParamModel param); 
    
    
    /**
     * 
     * @param  BusParamModel
     * @return List<BusStopInfo>
     */    
    public List<BusStopInfo> selectWithinBusStop(BusParamModel param);     
}
