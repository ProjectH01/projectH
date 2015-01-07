package com.projectH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectH.dao.GtookDAO;
import com.projectH.model.GtookBean;

@Service
public class GtookServiceImpl implements GtookService {

	@Autowired
	private GtookDAO gtookdao;

	@Override
	public void insertUserInfo(GtookBean user) {
		gtookdao.insertUserInfo(user);
	}

	@Override
	public GtookBean loadUserInfo(String userId) {
		return gtookdao.loadUserInfo(userId);
	}


	@Override
	public String useridCheck(String userId) {
		return gtookdao.useridCheck(userId);
	}

}
