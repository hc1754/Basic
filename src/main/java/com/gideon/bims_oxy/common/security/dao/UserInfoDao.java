package com.gideon.bims_oxy.common.security.dao;

import com.gideon.bims_oxy.common.security.model.UserInfo;

public interface UserInfoDao {

    public UserInfo selectUserInfo(String usrId);
    
}
