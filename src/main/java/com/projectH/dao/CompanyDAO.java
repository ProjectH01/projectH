package com.projectH.dao;

import java.util.List;

import com.projectH.model.CompanyBean;
import com.projectH.model.EventBean;


public interface CompanyDAO {

	CompanyBean idcheck(String company_id);

	void insertjoin(CompanyBean companybean);

	CompanyBean logincheck(String company_id);

	List<EventBean> geteventlist(EventBean eb);
	
	void insertevent(EventBean eventbean);
	
	void editevent(EventBean ev);

	EventBean geteventcont(String event);

	void eventstateedit(EventBean eb);

	int eventprogressLs(EventBean eb);




}
