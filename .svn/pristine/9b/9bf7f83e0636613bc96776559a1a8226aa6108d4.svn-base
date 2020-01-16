package com.gideon.bims_oxy.app.bis.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gideon.bims_oxy.app.bis.dao.MainScreenDao;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.FavoriteInfo;
import com.gideon.bims_oxy.app.bis.model.RouteInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;

@Service
public class MainScreenServiceImpl implements MainScreenService {
	
	private static final Logger logger = LoggerFactory.getLogger(MainScreenServiceImpl.class);
	
	@Autowired 
    private MainScreenDao dao;
	
	@Override
	public List<FavoriteInfo> selectFavoriteList(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectFavoriteList(param);
	}	

	@Override
	public List<RouteInfo> selectFavoriteRouteList(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectFavoriteRouteList(param);
	}

	@Override
	public List<BusStopInfo> selectFavoriteBusStopList(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectFavoriteBusStopList(param);
	}
	
	@Override
	public List<BusStopInfo> selectFavoriteMultiList(BusParamModel param) {
		param.setLanguageCode(LocaleContextHolder.getLocale().getLanguage());
		return dao.selectFavoriteMultiList(param);
	}	

	@Override
	public String editFavorite(BusParamModel param) {
		
		logger.error("param----" + param);
		
		String returnValue = "1";
		
		try {
			if(param != null) {
				
				logger.error("param.getQrUserId()----" + param.getQrUserId());
				logger.error("param.getFavoriteType()----" + param.getFavoriteType());
				logger.error("param.getRequestType()----" + param.getRequestType());
				
				//check mandatory necessary parameter
				if(StringUtils.isEmpty(param.getQrUserId()) 
						|| StringUtils.isEmpty(param.getFavoriteType()) 
						|| StringUtils.isEmpty(param.getRequestType())
				) {
					return returnValue;
				}
				
				String requestType = param.getRequestType();
	
				if("C".equals(requestType)) {
					dao.insertFavorite(param);
				} else {
					dao.deleteFavorite(param);
				}
				
				returnValue = "0";
			}			
		} catch (Exception ex) {
			logger.error("[ERROR] MainScreenServiceImpl.editFavorite ::: ", ex);
		}

		return returnValue;
	}
}
