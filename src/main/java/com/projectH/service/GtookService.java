package com.projectH.service;
import com.projectH.model.GtookBean;

public interface GtookService {


	void insertUserInfo(GtookBean user);//처음 접속자 db에 저장

	GtookBean loadUserInfo(String userId);//user정보 불러오기

	String useridCheck(String userId);//아이디 체크

}

