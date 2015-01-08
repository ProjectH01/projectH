package com.projectH.dao;

import java.util.List;

import com.projectH.model.CompanyBean;
import com.projectH.model.CompanycashBean;
import com.projectH.model.EventBean;
import com.projectH.model.EventreqBean;


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

	List<EventreqBean> eventreqlist(EventreqBean erb);

	void csstateedit(EventreqBean erb);

	int eventreqcount(EventreqBean erb);

	void changeCompanyPhone(CompanyBean cb);

	List<CompanycashBean> cashlist(CompanycashBean ccb);




}
