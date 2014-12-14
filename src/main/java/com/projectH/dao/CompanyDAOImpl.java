package com.projectH.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectH.model.CompanyBean;


@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@Autowired
	private SqlSession sqlsession;

	@Override
	public CompanyBean idcheck(String company_id) {
		return sqlsession.selectOne("id_check",company_id);
	}

	@Override
	public void insertjoin(CompanyBean companybean) {
		sqlsession.insert("company_in",companybean);
	}

	@Override
	public CompanyBean logincheck(String company_id) {
		return sqlsession.selectOne("login_check",company_id);
	}


}
