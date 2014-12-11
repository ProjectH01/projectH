package com.projectH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectH.dao.CompanyDAO;
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companydao;

}
