package com.gideon.bims_oxy.common.dao;

import java.util.HashMap;

import com.gideon.bims_oxy.common.model.I18nDtl;

public interface I18nDtlDao {
	
	public I18nDtl selectById(HashMap<String, Object> hMap);
}
