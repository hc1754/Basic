package com.gideon.bims_oxy.app.bis.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gideon.bims_oxy.app.bis.model.BusArriveInfo;
import com.gideon.bims_oxy.app.bis.model.BusStopInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;
import com.gideon.bims_oxy.app.bis.service.BusStopService;

@RestController
@RequestMapping(value = "/app/bis/busStop")
public class BusStopController {
	
	@Autowired
	private BusStopService busStopService;
	
	@RequestMapping(value = "/introView.do")
	public String introView(Model model) {
		return "bis/busStop" ;
	}

	@RequestMapping(value = "/selectBusStopHistory.json")
	public @ResponseBody HashMap<String, Object> selectBusStopHistory(BusParamModel param, Model model) {
		List<BusStopInfo> busStopList = busStopService.selectBusStopHistory(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busStopList", busStopList);
		return resultMap;
	}
	
	@RequestMapping(value = "/deleteBusStopHistory.json")
	public @ResponseBody String deleteBusStopHistory(BusParamModel param, Model model) {
		return busStopService.deleteBusStopHistory(param);
	}
	
	@RequestMapping(value = "/searchBusStop.json")
	public @ResponseBody HashMap<String, Object> searchBusStop(BusParamModel param, Model model) {
		List<BusStopInfo> searchResult = busStopService.searchBusStop(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busStopList", searchResult);
		return resultMap;
	}	
	
	@RequestMapping(value = "/selectArrivingBusListByBusStop.json")
	public @ResponseBody HashMap<String, Object> selectArrivingBusListByBusStop(BusParamModel param, Model model) {
		List<BusArriveInfo> busStopArriveList = busStopService.selectArrivingBusListByBusStop(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busStopArriveList", busStopArriveList);
		return resultMap;
	}	
	
	@RequestMapping(value = "/selectBusStopPosition.json")
	public @ResponseBody HashMap<String, Object> selectBusStopPosition(BusParamModel param, Model model) {
		List<BusStopInfo> busPositionList = busStopService.selectBusStopPosition(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("busStopList", busPositionList);
		return resultMap;
	}	
}
