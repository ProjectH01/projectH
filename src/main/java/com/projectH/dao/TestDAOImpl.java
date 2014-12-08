package com.projectH.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectH.model.TestBean;

@Repository
public class TestDAOImpl implements TestDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public TestBean test() {
		int test1=1;
		return this.sqlSession.selectOne("test",test1);  
	}

}
