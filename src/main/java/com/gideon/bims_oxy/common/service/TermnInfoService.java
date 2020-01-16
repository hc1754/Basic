package com.gideon.bims_oxy.common.service;

import java.util.HashMap;

public interface TermnInfoService {

	
	/**
	 * 단말기 ID 유무
	 * 
	 * @return
	 */
	public String selectTrcnId(HashMap<String, String> hMap);
	
}
