package com.projectH.dao;

import com.projectH.model.CompanyBean;


public interface CompanyDAO {

	CompanyBean idcheck(String company_id);

	void insertjoin(CompanyBean companybean);

	CompanyBean logincheck(String company_id);

}
