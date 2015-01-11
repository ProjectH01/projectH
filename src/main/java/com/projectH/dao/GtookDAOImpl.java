package com.projectH.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectH.model.GtookBean;

@Repository
public class GtookDAOImpl implements GtookDAO {

	@Autowired
	private SqlSession sqlsession;

	@Override
	public void insertUserInfo(GtookBean user) {
		sqlsession.insert("insertUser", user);
	}

	@Override
	public GtookBean loadUserInfo(String userId) {
		return sqlsession.selectOne("userInfo", userId);
	}

	@Override
	public String useridCheck(String userId) {
		String idcheck = sqlsession.selectOne("idcheck",userId);
		if(idcheck == null){
			idcheck="00000";
			return idcheck;
		}else{
			return idcheck;
		}
	}
}
