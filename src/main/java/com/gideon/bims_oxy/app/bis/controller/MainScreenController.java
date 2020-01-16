package com.gideon.bims_oxy.app.bis.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gideon.bims_oxy.app.bis.model.FavoriteInfo;
import com.gideon.bims_oxy.app.bis.model.inbound.BusParamModel;
import com.gideon.bims_oxy.app.bis.service.MainScreenService;

@Controller
@RequestMapping(value = "/app/bis/mainScreen")
public class MainScreenController {
	
	@Autowired
	private MainScreenService mainScreenService;
	
	@RequestMapping(value = "/introView.do")
	public String introView(BusParamModel param, Model model) {
		return "bis/mainScreen";
	}

	@RequestMapping(value = "/getMain.json")
	public @ResponseBody HashMap<String, Object> getMain(BusParamModel param, Model model) {
		List<FavoriteInfo> favoriteList = mainScreenService.selectFavoriteList(param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("favoriteList", favoriteList);
		return resultMap;
	}
	
	@RequestMapping(value = "/editFavorite.json")
	public @ResponseBody String editFavorite(BusParamModel param, Model model) {
		return mainScreenService.editFavorite(param);
	}	
}
