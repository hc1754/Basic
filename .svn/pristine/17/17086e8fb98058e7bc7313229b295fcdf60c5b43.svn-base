package com.gideon.bims_oxy.app.bis.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gideon.bims_oxy.app.bis.model.BusPositionInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.RouteInfo;
import com.gideon.bims_oxy.app.bis.model.RoutePositionInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;
import com.gideon.bims_oxy.app.bis.service.BusRouteService;

@Controller
@RequestMapping(value = "/app/bis/busRoute")
public class BusRouteController {
	
	@Autowired
	private BusRouteService busRouteService;
	
	@RequestMapping(value = "/introView.do")
	public String introView(Model model) {
		return "bis/busRoute";
	}

	@RequestMapping(value = "/selectBusRouteHistory.json")
	public @ResponseBody HashMap<String, Object> selectBusRouteHistory(BusParamModel param, Model model) {
		List<RouteInfo> busRouteList = busRouteService.selectBusRouteHistory(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busRouteList", busRouteList);
		return resultMap;
	}
	
	@RequestMapping(value = "/searchBusRoute.json")
	public @ResponseBody HashMap<String, Object> searchBusRoute(BusParamModel param, Model model) {
		List<RouteInfo> searchResult = busRouteService.searchBusRoute(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busRouteList", searchResult);
		return resultMap;
	}
	
	@RequestMapping(value = "/deleteBusRouteHistory.json")
	public @ResponseBody String deleteBusRouteHistory(BusParamModel param, Model model) {
		return busRouteService.deleteBusRouteHistory(param);
	}
	
	@RequestMapping(value = "/selectBusStopList.json")
	public @ResponseBody HashMap<String, Object> selectBusStopList(BusParamModel param, Model model) {
		List<BusStopInfo> busStopList = busRouteService.selectBusStopList(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busStopList", busStopList);
		return resultMap;
	}	
	
	@RequestMapping(value = "/selectRouteBusPositionList.json")
	public @ResponseBody HashMap<String, Object> selectRouteBusPositionList(BusParamModel param, Model model) {
		List<BusPositionInfo> busPositionList = busRouteService.selectRouteBusPositionList(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busPositionList", busPositionList);
		return resultMap;
	}	
	
	@RequestMapping(value = "/selectRouteOperation.json")
	public @ResponseBody HashMap<String, Object> selectRouteOperation(BusParamModel param, Model model) {
		RouteInfo routeOperation = busRouteService.selectRouteOperation(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("routeOperation", routeOperation);
		return resultMap;
	}	
	
	@RequestMapping(value = "/selectPassByRoute.json")
	public @ResponseBody HashMap<String, Object> selectPassByRoute(BusParamModel param, Model model) {
		List<RouteInfo> routeList = busRouteService.selectPassByRoute(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busRouteList", routeList);
		return resultMap;
	}	
	
	@RequestMapping(value = "/selectRoutePosition.json")
	public @ResponseBody HashMap<String, Object> selectRoutePosition(BusParamModel param, Model model) {
		List<RoutePositionInfo> routeList = busRouteService.selectRoutePosition(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busRoutePositionList", routeList);
		return resultMap;
	}	
}
