package com.gideon.bims_oxy.app.bis.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gideon.bims_oxy.app.bis.model.BusArriveInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

@Transactional
public interface BusStopService {

    /**
     * 
     * @param  BusParamModel
     * @return List<BusStopInfo>
     */    
    public List<BusStopInfo> selectBusStopHistory(BusParamModel param);
    
    /**
     * 
     * @param  BusParamModel
     * @return String
     */    
    public String deleteBusStopHistory(BusParamModel param);   

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

}
