package com.projectH.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectH.model.TestBean;
import com.projectH.service.TestService;

@Controller
public class TestAction {

	@Autowired
	private TestService testservice;
	
	@RequestMapping("test")
	public String test(Model m){
		TestBean test=this.testservice.test();
		m.addAttribute("m",test);
		return "test";
	}
}
