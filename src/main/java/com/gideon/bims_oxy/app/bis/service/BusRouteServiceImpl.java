package com.gideon.bims_oxy.app.bis.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gideon.bims_oxy.app.bis.dao.BusRouteDao;
import com.gideon.bims_oxy.app.bis.model.BusPositionInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.RouteInfo;
import com.gideon.bims_oxy.app.bis.model.RoutePositionInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

@Service
public class BusRouteServiceImpl implements BusRouteService {
	
	private static final Logger logger = LoggerFactory.getLogger(BusRouteServiceImpl.class);
	
	@Autowired 
    private BusRouteDao dao;

	@Override
	public List<RouteInfo> selectBusRouteHistory(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectBusRouteHistory(param);
	}

	@Override
	public List<RouteInfo> searchBusRoute(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.searchBusRoute(param);
	}

	@Override
	public String deleteBusRouteHistory(BusParamModel param) {
		String returnValue = "1";
		
		try {
			if(param != null) {
				//check mandatory parameter
				if( StringUtils.isEmpty(param.getQrUserId()) ) {
					return returnValue;
				}
				
				dao.deleteBusRouteHistory(param);
				
				returnValue = "0";
			}			
		} catch (Exception ex) {
			logger.error("[ERROR] BusRouteServiceImpl.deleteBusRouteHistory ::: ", ex);
		}

		return returnValue;
	}

	@Override
	public List<BusStopInfo> selectBusStopList(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectBusStopList(param);
	}
	
	@Override
	public List<BusPositionInfo> selectRouteBusPositionList(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectRouteBusPositionList(param);
	}	

	@Override
	public RouteInfo selectRouteOperation(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectRouteOperation(param);
	}

	@Override
	public List<RouteInfo> selectPassByRoute(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectPassByRoute(param);
	}

	@Override
	public List<RoutePositionInfo> selectRoutePosition(BusParamModel param) {
		return dao.selectRoutePosition(param);
	}
}
