package com.gideon.bims_oxy.common.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gideon.bims_oxy.common.dao.TermnInfoDao;

@Service
public class TermnInfoServiceImpl implements TermnInfoService {

	@Autowired 
    private TermnInfoDao dao;
	
	/**
	 * 단말기 ID 유무
	 * 
	 * @return
	 */
	public String selectTrcnId(HashMap<String, String> hMap) {
		return dao.selectTrcnId(hMap);
	}
}
