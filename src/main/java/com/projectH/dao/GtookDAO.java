package com.projectH.dao;

import com.projectH.model.GtookBean;

public interface GtookDAO {



	void insertUserInfo(GtookBean user);

	GtookBean loadUserInfo(String userId);

	String useridCheck(String userId);

}
