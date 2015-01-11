package com.projectH.action;

import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projectH.model.GtookBean;
import com.projectH.service.GtookService;

@Controller
public class GtookAction {

	@Autowired
	private GtookService gtookservice;
	
	@RequestMapping("/main.com")
	public ModelAndView main(){
		ModelAndView m = new ModelAndView("main");
		return m;
	}
	
	
	@RequestMapping("/main_ok.com")
	@ResponseBody
	public String main_ok(@RequestBody String res,HttpServletRequest request,HttpSession session) throws Exception {
		
		session=request.getSession();
		String userInfo = URLDecoder.decode(res,"UTF-8");
		String userId = userInfo.split("&")[0].replace("id=", "");
		String nickname =userInfo.split("&")[1].replace("properties[nickname]=", "");
		String checkId=gtookservice.useridCheck(userId);
		session.setAttribute("userId",userId);
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
	@RequestMapping("/logout.com")
	public String logout(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		session=request.getSession();
		session.invalidate();
		out.println("<script>");
		out.println("alert('로그아웃되었습니다');");
		out.println("location='main.com';");
		out.println("</script>");
		return null;
	}
	
	@RequestMapping("/mypage.com")
	public ModelAndView mypage(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		session=request.getSession();
		String id=(String)session.getAttribute("userId");
		if(id == null){
			ModelAndView err = new ModelAndView("gtook/errorpage");
			return err;
		}else if(id != null){
		}
		ModelAndView m = new ModelAndView("gtook/mypage");
		return m;
	}
	
	@RequestMapping("/errorpage.com")
	public String err(){
		return "gtook/errorpage";
	}
	
	@RequestMapping("/test.com")
	public String test(){
		
		return "test";
	}
	
}
