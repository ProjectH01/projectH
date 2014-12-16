package com.projectH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectH.dao.CompanyDAO;
import com.projectH.model.CompanyBean;
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


}
