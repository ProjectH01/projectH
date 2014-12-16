package com.projectH.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pwdconv.PwdChange;

import com.projectH.model.CompanyBean;
import com.projectH.service.CompanyService;

@Controller
public class CompanyAction {

	@Autowired
	private CompanyService companyservice;
	

	@RequestMapping("/company_index.com")
	public String company_index(){
		return "company/company_index";
	}

	@RequestMapping("/company_join.com")
	public String company_join(){
		return "company/company_join";
	}
	
	//부관리자 가입,중복아이디 검사
	@RequestMapping("/company_join_ok.com")
	public String company_join_ok(@ModelAttribute CompanyBean companybean,
			   HttpServletResponse response) throws Exception{
			
		 response.setContentType("text/html;charset=UTF-8");
		   //웹상에 출력되는 파일형식과 언어코딩 타입을 설정
		   PrintWriter out=response.getWriter();
		   
		   CompanyBean cb=this.companyservice.idcheck(companybean.getCompany_id());
		   //중복 아이디 검색
		   if(cb != null){
			   out.println("<script>");
			   out.println("alert('중복 아이디가 존재 합니다!');");
			   out.println("history.back();");
			   out.println("</script>");
		   }else{
			   companybean.setCompany_pwd(
			   PwdChange.getPassWordToXEMD5String(companybean.getCompany_pwd()));
			   //MD5로 암호화
			   this.companyservice.insertJoin(companybean);//회원 저장
			   return "redirect:/company_index.com";
		   }
		   return null;
	}
	
		@RequestMapping("/company_main.com")
		public String company_main(HttpServletResponse response,
				   HttpServletRequest request,
				   HttpSession session)throws Exception{
			response.setContentType("text/html;charset=UTF-8");
			   PrintWriter out=response.getWriter();
			   session=request.getSession();
			   String id=(String)session.getAttribute("company_id");
			   if(id==null){
				   out.println("<script>");
				   out.println("alert('다시 로그인 하세요!');");
				   out.println("location='company_index.com';");
				   out.println("</script>");
			   }else if(id != null){
				   return "company/company_main";
			   }
			   return null;
		}
		
		//부관리자 로그인 인증
		@RequestMapping("/company_login_ok.com")
		public String member_login_ok(
				@RequestParam("company_id") String company_id,
				@RequestParam("company_pwd") String company_pwd,
				HttpServletResponse response, HttpServletRequest request, HttpSession session,Model m) throws Exception{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			session=request.getSession();//세션 객체 생성
			
			CompanyBean cb=this.companyservice.loginCheck(company_id);
			if(cb == null){
				out.println("<script>");
				out.println("alert('가입 안된 회원입니다!');");
				out.println("history.back();");
				out.println("</script>");
			}else{
				company_pwd=PwdChange.getPassWordToXEMD5String(company_pwd);
				//비번 암호화
				if(!cb.getCompany_pwd().equals(company_pwd)){
					out.println("<script>");
					out.println("alert('비번이 다릅니다!');");
					out.println("history.go(-1)");
					out.println("</script>");
				}else{
					session.setAttribute("id",company_id);
					 m.addAttribute("phone",cb.getCompany_phone());
					 m.addAttribute("letter",cb.getCompany_letter());
					  m.addAttribute("tcash",cb.getCompany_total_cash());
					return "company/company_main";
				}
			}
			return null;
	}
		//부관리자 로그아웃
		@RequestMapping("/company_logout.com")
		public String logout(HttpServletResponse response,HttpSession session,
				HttpServletRequest request)	throws Exception{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			session=request.getSession();
			session.invalidate();//세션을 만료
			out.println("<script>");
			out.println("alert('로그아웃되었습니다!');");
			out.println("location='company_index.com';");
			out.println("</script>");
			return null;
		}
		@RequestMapping("/company_event.com")
		public String company_event(){
			return "company/company_event";
		}
		@RequestMapping("/company_event_write.com")
		public String company_event_write(){
			return "company/company_event_write";
		}
}