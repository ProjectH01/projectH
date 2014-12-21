package com.projectH.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectH.dao.CompanyDAO;
import com.projectH.model.CompanyBean;
import com.projectH.model.EventBean;
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companydao;

	@Override
	public CompanyBean idcheck(String company_id) {
		return companydao.idcheck(company_id);
	}

	@Override
	public void insertJoin(CompanyBean companybean) {
		companydao.insertjoin(companybean);
	}

	@Override
	public CompanyBean loginCheck(String company_id) {
		return companydao.logincheck(company_id);
	}

	@Override
	public List<EventBean> getEventList(EventBean eb) {
		return companydao.geteventlist(eb);
	}
	
	@Override
	public void insertEvent(EventBean eventbean) {
		companydao.insertevent(eventbean);
	}

	@Override
	public void editEvent(EventBean ev) {
		companydao.editevent(ev);		
	}

	@Override
	public EventBean geteventCont(String event) {
		return companydao.geteventcont(event);
	}

	@Override
	public void eventstateEdit(EventBean eb) {
		companydao.eventstateedit(eb);
	}

	@Override
	public int eventprogress(EventBean eb) {
		return companydao.eventprogressLs(eb);
		
	}


	


}
