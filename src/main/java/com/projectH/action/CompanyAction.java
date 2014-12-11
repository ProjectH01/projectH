package com.projectH.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectH.service.CompanyService;

@Controller
public class CompanyAction {

	@Autowired
	private CompanyService companyservice;
	
	@RequestMapping("/company_index.com")
	public String company_index(){
		return "company/company_index";
	}

}