package com.gideon.bims_oxy.app.bis.model;

public class FavoriteInfo {
	
	private String routeId;
	private String routeNumber;
	private String routeName;
	private String busStopId;
	private String busStopName;
	private String favoriteType;
	private Integer registSequence;
	private String registDate;

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

	public String getBusStopId() {
		return busStopId;
	}

	public void setBusStopId(String busStopId) {
		this.busStopId = busStopId;
	}

	public String getBusStopName() {
		return busStopName;
	}

	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}

	public String getFavoriteType() {
		return favoriteType;
	}

	public void setFavoriteType(String favoriteType) {
		this.favoriteType = favoriteType;
	}

	public Integer getRegistSequence() {
		return registSequence;
	}

	public void setRegistSequence(Integer registSequence) {
		this.registSequence = registSequence;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
}
