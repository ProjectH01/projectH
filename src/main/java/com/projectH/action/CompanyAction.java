package com.projectH.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pwdconv.PwdChange;

import com.oreilly.servlet.MultipartRequest;
import com.projectH.model.CompanyBean;
import com.projectH.model.EventBean;
import com.projectH.model.EventreqBean;
import com.projectH.model.UserBean;
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
		
		//광고중인 이벤트 갯수, 이벤트 상담요청갯수, 현재 충전금액
		@RequestMapping("/company_main.com")
		public String company_main(HttpServletResponse response,
				   HttpServletRequest request, Model m,
				   HttpSession session,CompanyBean cb, EventBean eb, EventreqBean erb)throws Exception{

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
				   //m.addAttribute("company_phone",cb.getCompany_phone());
				   //m.addAttribute("company_letter",cb.getCompany_letter());
				 
				   //System.out.println(cb.getCompany_total_cash()+"충전금액");
				   //System.out.println(eb.getEve_state()+"hhjhh");
				  
				   eb.setCompany_id(id);
				   erb.setCompany_id(id);
				   int event_pro_listcount = companyservice.eventprogress(eb);
				   int event_req_listcount = companyservice.eventreqcount(erb);
				   
				   m.addAttribute("event_pro_listcount",event_pro_listcount);
				   m.addAttribute("event_req_listcount",event_req_listcount);
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
			session.setAttribute("company_id",company_id);
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
					session.setAttribute("company_phone",cb.getCompany_phone());
					session.setAttribute("company_letter",cb.getCompany_letter());
					session.setAttribute("company_name",cb.getCompany_name());
					session.setAttribute("company_total_cash",cb.getCompany_total_cash());
					
					return "redirect:/company_main.com";
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
		
		//이벤트 광고중 바꾸기
		@RequestMapping("company_event_state_edit")
		public String company_event_state_edit(HttpServletResponse response,HttpSession session,
				HttpServletRequest request, Model m, CompanyBean cb, EventBean eb) throws Exception{
				
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
				   eb.setEvent(new String(eb.getEvent().getBytes("ISO-8859-1"),"UTF-8"));
				   if(eb.getEve_state() == 1){
					   eb.setEve_state(0);
				   }else if(eb.getEve_state() == 0){
					   eb.setEve_state(1);
				   }
				   
				   companyservice.eventstateEdit(eb);
				   return "redirect:/company_event.com";
			   }
			return null;
		}

		//이벤트 리스트
		@RequestMapping("/company_event.com")
		public String company_event(HttpServletResponse response,HttpSession session,
				HttpServletRequest request, Model m, CompanyBean cb, EventBean eb)throws Exception {
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
//				   session.setAttribute("id",company_id);
				   m.addAttribute("company_phone",cb.getCompany_phone());
				   m.addAttribute("company_letter",cb.getCompany_letter());
 
				   eb.setCompany_id(id);
				   List<EventBean> elist=this.companyservice.getEventList(eb);//목록

				   m.addAttribute("elist", elist);

				   return "company/company_event";
			   }
			   return null;
		}
		
		
		
		//이벤트 작성
		@RequestMapping("/company_event_write.com")
		public String company_event_write(HttpServletResponse response,HttpSession session,
				HttpServletRequest request, Model m, CompanyBean cb) throws Exception {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			session=request.getSession();
			
	     String id=(String)session.getAttribute("company_id");
	     if(id==null){
	    	 out.println("<script>");
	    	 out.println("alert('다시 로그인 하세요!')");
	    	 out.println("location='company_index.com';");
	    	 out.println("</script>");
	     	}else if(id != null){
//				   session.setAttribute("id",company_id);
				   m.addAttribute("company_phone",cb.getCompany_phone());
				   m.addAttribute("company_letter",cb.getCompany_letter());
 
				   return "company/company_event_write";
			   }
			   return null;
		}
		
			//이벤트 등록
		   @RequestMapping(value="/company_event_write_ok.com")
		    public String company_event_write_ok(HttpServletRequest request, HttpServletResponse response, HttpSession session, 
		                @ModelAttribute EventBean eventbean ) throws Exception {
		          
		          response.setContentType("text/html;charset=UTF-8");
		          PrintWriter out=response.getWriter();
		          session=request.getSession();//세션 객체 생성
		          String company_id=(String)session.getAttribute("company_id");
		          if(company_id == null){
		             out.println("<script>");
		             out.println("alert('다시 로그인 하세요!')");
		             out.println("location='company_index.com';");
		             out.println("</script>");
		          }else{
		          String saveFolder="C:/Users/USER/git/projectH/src/main/webapp/upload";
		          //이진파일 업로드 경로      
		          int fileSize=5*1024*1024;//이진파일 업로드 최대크기,5mb
		       
		          MultipartRequest multi=null;//이진파일 업로드 변수선언

		          multi=new MultipartRequest(request,saveFolder,fileSize,"UTF-8");

		       
		          String event=multi.getParameter("event").trim();
		          int db_price=Integer.parseInt(multi.getParameter("db_price"));
		       
		           File UpFile=multi.getFile("banner_image");//첨부한 이진파일을 가져옴
		           File UpFile2=multi.getFile("detail_image");//첨부한 이진파일을 가져옴

		           
		           if(UpFile != null && UpFile2 != null){//첨부한 이진파일이 있을때 실행
		              String fileName=UpFile.getName();//첨부한 이진파일명을 구함
		              String fileName2=UpFile2.getName();//첨부한 이진파일명을 구함
		              Calendar c=Calendar.getInstance();
		              int year=c.get(Calendar.YEAR);
		              int month=c.get(Calendar.MONTH)+1;
		              int date=c.get(Calendar.DATE);
		              
		          String homedir=saveFolder+"/banner"+"/"+year+"-"+month+"-"+date;
		          String homedir2=saveFolder+"/detail"+"/"+year+"-"+month+"-"+date;

		          //새로운 이진파일 폴더 경로를 저장
		              File path1=new File(homedir);
		              if(!(path1.exists())){//폴더경로가 없으면
		                 path1.mkdir();//폴더를 생성
		              }
		              
		              File path2=new File(homedir2);
		              if(!(path2.exists())){//폴더경로가 없으면
		                 path2.mkdir();//폴더를 생성
		              }
		              
		              Random r=new Random();//난수를 발생시키는 클래스
		              int random=r.nextInt(100000000);
		              //1억사이의 정수형 난수를 발생시킴
		              
		              /****확장자 구하기 시작 ****/
		             int index = fileName.lastIndexOf(".");
		             String fileExtension = fileName.substring(index + 1);
		             /****확장자 구하기 끝 ***/
		             /****확장자 구하기 시작 ****/
		             int index2 = fileName2.lastIndexOf(".");
		             String fileExtension2 = fileName2.substring(index2 + 1);

		             /****확장자 구하기 끝 ***/
		             String refileName="banner"+year+month+date+random+"."+
		                   fileExtension;//새로운 파일명을 저장  
		             String refileName2="detail"+year+month+date+random+"."+
		                   fileExtension;//새로운 파일명을 저장  
		             
		          String fileDBName="/"+year+"-"+month+"-"+date+"/"+
		                   refileName;//데이터베이스에 저장될 레코드값
		          String fileDBName2="/"+year+"-"+month+"-"+date+"/"+
		                refileName2;//데이터베이스에 저장될 레코드값
		          
		          UpFile.renameTo(new File(homedir+"/"+refileName));
		          //새롭게 생성된 폴더에 바뀐 이진파일명으로 업로드
		          UpFile2.renameTo(new File(homedir2+"/"+refileName2));
		          //새롭게 생성된 폴더에 바뀐 이진파일명으로 업로드
		          
		          eventbean.setBanner_image(fileDBName);
		          eventbean.setDetail_image(fileDBName2);

		           }else{//이진파일을 첨부하지 않았을때
		              String fileDBName="";
		              String fileDBName2="";
		              eventbean.setBanner_image(fileDBName);//첨부하지 않은 경우는 빈공백을
		              eventbean.setDetail_image(fileDBName2);//첨부하지 않은 경우는 빈공백을
		              //저장시킴
		           }
		           eventbean.setEvent(event);
		           eventbean.setDb_price(db_price);
		           eventbean.setCompany_id(company_id);
		               
		           
		               this.companyservice.insertEvent(eventbean);//저장메서드 호출
		               
		                return "redirect:/company_event.com";
		             }
		          return null;
		       }
		   
		   //이벤트 수정내용보기
		   @RequestMapping("/company_event_edit.com")
			public ModelAndView company_event_edit(
					@RequestParam("event") String event,HttpServletResponse response, HttpSession session,
					HttpServletRequest request) throws Exception{
	
			   	response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				session=request.getSession();
			   
				String id=(String)session.getAttribute("company_id");
		        if(id == null){
		        	out.println("<script>");
		        	out.println("alert('다시 로그인 하세요!')");
		        	out.println("location='company_index.com'");
		        	out.println("</script>");
		        }
		        
		        event=new String(event.getBytes("ISO-8859-1"),"UTF-8");
		        
			   EventBean ev=this.companyservice.geteventCont(event);
			   
			   ModelAndView cm=new ModelAndView("company/company_event_edit");
			   cm.addObject("ev",ev);
			   
			   return cm;
		   }
		   
		   //이벤트 수정
		   @RequestMapping("/company_event_edit_ok.com")
			public String company_event_edit_ok(HttpServletResponse response,HttpSession session,
					HttpServletRequest request, Model m, @ModelAttribute EventBean event)throws Exception{
			    
			   	response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				session=request.getSession();
			   
				String id=(String)session.getAttribute("company_id");
		        if(id == null){
		        	out.println("<script>");
		        	out.println("alert('다시 로그인 하세요!')");
		        	out.println("location='company_index.com'");
		        	out.println("</script>");
		        }else{
		        	String saveFolder="C:/Users/USER/git/projectH/src/main/webapp/upload";
			        //이진파일 업로드 경로      
		        	int fileSize=5*1024*1024;//이진파일 업로드 최대크기,5mb
		        	MultipartRequest multi=null;
		        	multi=new MultipartRequest(request,saveFolder,fileSize,"UTF-8");
		        	//이진파일 업로드 객체 생성
		        	//request는 사용자폼에서 입력한 정보를 서버로 가져오는 역할
		        	//saveFolder는 이진파일 업로드 서버 경로
		        	//fileSize는 이진파일 업로드 최대 크기
		        	//UTF-8은 언어코딩 타입설정
		        	String eventp=multi.getParameter("event").trim();
			        int db_price=Integer.parseInt(multi.getParameter("db_price"));
		     
			        File UpFile=multi.getFile("banner_image");//첨부한 이진파일을 가져옴
			        File UpFile2=multi.getFile("detail_image");//첨부한 이진파일을 가져옴

		        	if(UpFile != null && UpFile2 != null){//첨부한 이진파일이 존재한다면
		        		 String fileName=UpFile.getName();//첨부한 이진파일명을 구함
			             String fileName2=UpFile2.getName();//첨부한 이진파일명을 구함
		        		 
			             File DelFile=new File(saveFolder+event.getBanner_image());
			             File DelFile2=new File(saveFolder+event.getDetail_image());
		        			//삭제할 파일 객체를 생성
		        			if(DelFile.exists() && DelFile2.exists()){//삭제할 파일 객체가 존재하면
		        				DelFile.delete();//이진파일을 삭제
		        				DelFile2.delete();
		        			}
		        			Calendar c=Calendar.getInstance();
				            int year=c.get(Calendar.YEAR);
				            int month=c.get(Calendar.MONTH)+1;
				            int date=c.get(Calendar.DATE);
		        			
				             String homedir=saveFolder+"/banner"+"/"+year+"-"+month+"-"+date;
					         String homedir2=saveFolder+"/detail"+"/"+year+"-"+month+"-"+date;
					         File path1=new File(homedir);
				              if(!(path1.exists())){//폴더경로가 없으면
				                 path1.mkdir();//폴더를 생성
				              }
				              File path2=new File(homedir2);
				              if(!(path2.exists())){//폴더경로가 없으면
				                 path2.mkdir();//폴더를 생성
				              }
				              Random r=new Random();//난수를 발생시키는 클래스
				              int random=r.nextInt(100000000);
				              //1억사이의 정수형 난수를 발생시킴
				              
				              /****확장자 구하기 시작 ****/
					          int index = fileName.lastIndexOf(".");
					          String fileExtension = fileName.substring(index + 1);
					          /****확장자 구하기 끝 ***/
					          /****확장자 구하기 시작 ****/
					          int index2 = fileName2.lastIndexOf(".");
					          String fileExtension2 = fileName2.substring(index2 + 1);
					          /****확장자 구하기 끝 ***/
					          String refileName="banner"+year+month+date+random+"."+
					                   fileExtension;//새로운 파일명을 저장  
					          String refileName2="detail"+year+month+date+random+"."+
					                   fileExtension;//새로운 파일명을 저장  
					             
					          String fileDBName="/"+year+"-"+month+"-"+date+"/"+
					                   refileName;//데이터베이스에 저장될 레코드값
					          String fileDBName2="/"+year+"-"+month+"-"+date+"/"+
					                refileName2;//데이터베이스에 저장될 레코드값
					          UpFile.renameTo(new File(homedir+"/"+refileName));
					          //새롭게 생성된 폴더에 바뀐 이진파일명으로 업로드
					          UpFile2.renameTo(new File(homedir2+"/"+refileName2));
					          //새롭게 생성된 폴더에 바뀐 이진파일명으로 업로드
					          event.setBanner_image(fileDBName);
					          event.setDetail_image(fileDBName2);
					          
		        		}else{//첨부하지 않은 경우
		        			if(event.getBanner_image() != null && event.getDetail_image() != null){
		        				event.setBanner_image(event.getBanner_image());
		        				event.setDetail_image(event.getDetail_image());
		        			//기존 이진파일을 가져와 저장
		        			}else{
		        			  String fileDBName="";
		  		              String fileDBName2="";
		  		            event.setBanner_image(fileDBName);//첨부하지 않은 경우는 빈공백을
		  		            event.setDetail_image(fileDBName2);//첨부하지 않은 경우는 빈공백을
		  		              //저장시킴
		        			}
		        		}
		        		event.setEvent(eventp);
		        		event.setDb_price(db_price);
		        		
		        		this.companyservice.editEvent(event);//수정메서드를 호출
		        		return "redirect:/company_event.com";
		        	}
		        	   
		        			return null;
		        		}
		   
		   //상담문의 관리
		   @RequestMapping("/company_ask.com")
		   public String company_ask(HttpServletResponse response, HttpSession session,
					HttpServletRequest request, Model m, EventreqBean erb, CompanyBean cb) throws Exception {
			   	
			   response.setContentType("text/html;charset=UTF-8");
		          PrintWriter out=response.getWriter();
		          session=request.getSession();//세션 객체 생성
		          String company_id=(String)session.getAttribute("company_id");
		          if(company_id == null){
		             out.println("<script>");
		             out.println("alert('다시 로그인 하세요!')");
		             out.println("location='company_index.com';");
		             out.println("</script>");
		          }else if(company_id != null){
		        	  
		        	int page=1;
		      		int limit=5;			

		      		String find_name=null;
		      		String find_field=null;

		      		if(request.getParameter("find_name") != null){
		      			find_name=request.getParameter("find_name").trim();	
		      			find_name=new String(find_name.getBytes("ISO-8859-1"),"UTF-8");
		      			//get방식으로 넘어온 한글을 안깨지게 할려면 String클래스의 
		      			//getBytes()메서드를 사용해야 한다.
		      		}
		      		find_field=request.getParameter("find_field");
		      		//검색필드를 저장함.bbs_title,bbs_cont를 저장
		      		erb.setFind_field(find_field);
		      		erb.setFind_name("%"+find_name+"%");
		      		//%는 오라클 쿼리문 검색연산자로서 하나이상의임의의 문자와
		      		//매핑을 한다.?는 오라클 쿼리문 검색연산자로서 하나의 문자
		      		//와 매핑을 한다.(오라클 월말평가 문제 예상)

		      		//System.out.println(find_name);
		      		//이클립스 콘솔모드에 검색어가 출력

		      		if(request.getParameter("page") != null){
		      			page=Integer.parseInt(request.getParameter("page"));
		      			//get방식으로 넘어온 쪽번호를 정수형 숫자로 바꿔서 좌측변수에 저장한다.
		      		}

		  
		      		int event_req_listcount = companyservice.eventreqcount(erb);
//		      		System.out.println("----------------"+event_req_listcount);
		      		erb.setStartrow((page-1)*5);
		      		erb.setEndrow(erb.getStartrow()+limit-1);

					   m.addAttribute("company_phone",cb.getCompany_phone());
					   m.addAttribute("company_letter",cb.getCompany_letter());
	 
					   erb.setCompany_id(company_id);

					   List<EventreqBean> rlist=this.companyservice.getEventreqList(erb);//목록
					   //총 페이지 수.
					   int maxpage=(int)((double)event_req_listcount/limit+0.95); //0.95를 더해서 올림 처리.
						//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
					   int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
						//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
					   int endpage = maxpage;

					   if (endpage>startpage+10-1) endpage=startpage+10-1;
					   
//					   System.out.println(rlist.get(0).getUser_id()+"1");
//					   System.out.println(rlist.get(0).getCs_time()+"2");
//					   System.out.println(rlist.get(0).getCs_date()+"3");
//					   System.out.println(rlist.get(0).getCs_state()+"4");
//					   System.out.println(rlist.get(0).getEvent()+"5");
					   
					   m.addAttribute("rlist", rlist);
					   m.addAttribute("page", page);
					   m.addAttribute("startpage", startpage);
					   m.addAttribute("endpage", endpage);
					   m.addAttribute("maxpage", maxpage);
					   m.addAttribute("event_req_listcount",event_req_listcount);	
					   m.addAttribute("find_field",find_field);
						//find_field 키값에 board_title,board_cont저장
					   m.addAttribute("find_name", find_name);
						//find_name 키값에 검색어를 저장

					   return "company/company_ask";
				   }
				   return null;
		   }
		   
		   //상담문의 신규,완료,재상담 바꾸기
		   @RequestMapping("/company_cs_state_edit.com")
		   public String company_ask_state(HttpServletResponse response, HttpSession session,
					HttpServletRequest request, EventreqBean erb, Model m) throws Exception {
			   
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
				   erb.setEvent(new String(erb.getEvent().getBytes("ISO-8859-1"),"UTF-8"));
				   if(erb.getCs_state() == 0){
					   erb.setCs_state(1);
				   }else if(erb.getCs_state() == 1){
					   erb.setCs_state(2);
				   }else if(erb.getCs_state() == 2){
					   erb.setCs_state(0);
				   }
				
				   companyservice.csstateEdit(erb);
				   return "redirect:/company_ask.com";
			   }
			   return null;
		   }
		   
		   //충전금 내역
		   @RequestMapping("/company_cash.com")
		   public String company_cash(HttpServletResponse response, HttpSession session,
					HttpServletRequest request, Model m, CompanyBean cb) throws Exception {
			   
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
				   m.addAttribute("company_phone",cb.getCompany_phone());
				   m.addAttribute("company_letter",cb.getCompany_letter());
 
				   
				   
			   return "company/company_cash";
		   }
			   return null;
		   }
		   
		   //상담번호, 문자번호 변경
		   @RequestMapping("change_company_phone.com")
		   public String change_company_phone(HttpServletResponse response, HttpSession session,
					HttpServletRequest request, Model m, CompanyBean cb) throws Exception {
			   
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
				   cb.setCompany_id(id);
				   companyservice.changeCompanyPhone(cb);
				   cb=this.companyservice.loginCheck(id);
					session.setAttribute("id",id);
					session.setAttribute("company_phone",cb.getCompany_phone());
					session.setAttribute("company_letter",cb.getCompany_letter());
					session.setAttribute("company_name",cb.getCompany_name());
					session.setAttribute("company_total_cash",cb.getCompany_total_cash());
					
					return "redirect:/company_main.com";
			   }
			   
			   return null;
		   }
}