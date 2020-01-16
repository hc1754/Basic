package com.gideon.bims_oxy.app.bis.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gideon.bims_oxy.app.bis.dao.BusStopDao;
import com.gideon.bims_oxy.app.bis.model.BusArriveInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

@Service
public class BusStopServiceImpl implements BusStopService {
	
	private static final Logger logger = LoggerFactory.getLogger(BusStopServiceImpl.class);
	
	@Autowired 
    private BusStopDao dao;

	@Override
	public List<BusStopInfo> selectBusStopHistory(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectBusStopHistory(param);
	}
	
	@Override
	public String deleteBusStopHistory(BusParamModel param) {
		String returnValue = "1";
		
		try {
			if(param != null) {
				//check mandatory parameter
				if( StringUtils.isEmpty(param.getQrUserId()) ) {
					return returnValue;
				}
				
				dao.deleteBusStopHistory(param);
				
				returnValue = "0";
			}			
		} catch (Exception ex) {
			logger.error("[ERROR] BusStopServiceImpl.deleteBusStopHistory ::: ", ex);
		}

		return returnValue;
	}	

	@Override
	public List<BusStopInfo> searchBusStop(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.searchBusStop(param);
	}

	@Override
	public List<BusArriveInfo> selectArrivingBusListByBusStop(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectArrivingBusListByBusStop(param);
	}
	
	@Override
	public List<BusStopInfo> selectBusStopPosition(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		List<BusStopInfo> busPositionList = new ArrayList<BusStopInfo>();
		
		if( StringUtils.isEmpty(param.getBusStopId()) ) {
			busPositionList = dao.selectWithinBusStop(param);
		} else {
			busPositionList = dao.selectBusStopPosition(param);
		}
		
		return busPositionList;
	}	
}
