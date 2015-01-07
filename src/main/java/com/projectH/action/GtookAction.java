package com.projectH.action;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectH.model.GtookBean;
import com.projectH.service.GtookService;

@Controller
public class GtookAction {

	@Autowired
	private GtookService gtookservice;
	
	@RequestMapping("/main.com")
	public String main(){
		return "main";
	}
	@RequestMapping("/main_ok.com")
	@ResponseBody
	public String main_ok(@RequestBody String res) throws Exception {
		String userInfo = URLDecoder.decode(res,"UTF-8");
		String userId = userInfo.split("&")[0].replace("id=", "");
		String nickname =userInfo.split("&")[1].replace("properties[nickname]=", "");
		String checkId=gtookservice.useridCheck(userId);
		if(checkId == "00000"){
			GtookBean user = new GtookBean();
			user.setUser_id(userId);
			user.setUser_name(nickname);
			gtookservice.insertUserInfo(user);
			return "0";
		}else{
			GtookBean dbInfo = gtookservice.loadUserInfo(userId);
			int point = dbInfo.getUser_point();
			String result = Integer.toString(point);
			return result;
		}
		
		
	}
	@RequestMapping("/test.com")
	public String test(){
		
		return "test";
	}
	
}
