package com.projectH.service;

import com.projectH.model.CompanyBean;


public interface CompanyService {

	CompanyBean idcheck(String company_id);

	void insertJoin(CompanyBean companybean);

	CompanyBean loginCheck(String company_id);


}
