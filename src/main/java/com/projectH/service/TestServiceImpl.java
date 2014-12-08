package com.projectH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectH.dao.TestDAO;
import com.projectH.model.TestBean;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDAO testdao;

	@Override
	public TestBean test() {
		return this.testdao.test();
	}

}
