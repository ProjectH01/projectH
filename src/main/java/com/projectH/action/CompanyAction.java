package com.projectH.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.projectH.service.CompanyService;

@Controller
public class CompanyAction {

	@Autowired
	private CompanyService companyservice;
	
	
}
