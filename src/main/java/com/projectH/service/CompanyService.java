package com.projectH.service;

import java.util.List;

import com.projectH.model.CompanyBean;
import com.projectH.model.EventBean;
import com.projectH.model.EventreqBean;


public interface CompanyService {

	CompanyBean idcheck(String company_id);

	void insertJoin(CompanyBean companybean);

	CompanyBean loginCheck(String company_id);

	List<EventBean> getEventList(EventBean eb);
	
	void insertEvent(EventBean eventbean);
	
	void editEvent(EventBean ev);

	EventBean geteventCont(String event);

	void eventstateEdit(EventBean eb);

	int eventprogress(EventBean eb);

	List<EventreqBean> getEventreqList(EventreqBean erb);

	void csstateEdit(EventreqBean erb);

	int eventreqcount(EventreqBean erb);

	void changeCompanyPhone(CompanyBean cb);






}
