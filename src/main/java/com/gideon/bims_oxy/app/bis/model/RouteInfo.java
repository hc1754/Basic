package com.gideon.bims_oxy.app.bis.model;

import java.math.BigDecimal;

public class RouteInfo {
	
	private String routeId;
	private String routeNumber;
	private String routeName;
	private String favoriteYn;
	private String favoriteType;
	
	private String startDName;
	private String startDFirstTime;
	private String startDLastTime;
	private String endDName;
	private String endDFirstTime;
	private String endDLastTime;
	
	private BigDecimal dispatchInterval;

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getFavoriteYn() {
		return favoriteYn;
	}

	public void setFavoriteYn(String favoriteYn) {
		this.favoriteYn = favoriteYn;
	}

	public String getFavoriteType() {
		return favoriteType;
	}

	public void setFavoriteType(String favoriteType) {
		this.favoriteType = favoriteType;
	}

	public String getStartDName() {
		return startDName;
	}

	public void setStartDName(String startDName) {
		this.startDName = startDName;
	}

	public String getStartDFirstTime() {
		return startDFirstTime;
	}

	public void setStartDFirstTime(String startDFirstTime) {
		this.startDFirstTime = startDFirstTime;
	}

	public String getStartDLastTime() {
		return startDLastTime;
	}

	public void setStartDLastTime(String startDLastTime) {
		this.startDLastTime = startDLastTime;
	}

	public String getEndDName() {
		return endDName;
	}

	public void setEndDName(String endDName) {
		this.endDName = endDName;
	}

	public String getEndDFirstTime() {
		return endDFirstTime;
	}

	public void setEndDFirstTime(String endDFirstTime) {
		this.endDFirstTime = endDFirstTime;
	}

	public String getEndDLastTime() {
		return endDLastTime;
	}

	public void setEndDLastTime(String endDLastTime) {
		this.endDLastTime = endDLastTime;
	}

	public BigDecimal getDispatchInterval() {
		return dispatchInterval;
	}

	public void setDispatchInterval(BigDecimal dispatchInterval) {
		this.dispatchInterval = dispatchInterval;
	}
}
