package com.projectH.action;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projectH.model.KakaoBean;
import com.projectH.service.GtookService;

@Controller
public class GtookAction {

	@Autowired
	private GtookService gtookservice;
	
	@RequestMapping("/main.com")
	public String main(HttpServletRequest request,HttpSession session){
		
		return "main";
	}
	
//	
	@RequestMapping(value = "/somepath/login_ok", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView insertMulti(@RequestBody KakaoBean dataList ) {
		System.out.println("action으로 넘어옴");
		if(dataList !=null){
			System.out.println("json으로 값이 넘어왓습니다");
		}else if(dataList == null){
			System.out.println("다시 해 이놈아");
		}
		ModelAndView m = new ModelAndView("redirect:/main.com");							
		return m;}
	
	//
	//아래껀 예시
	@RequestMapping("/kakaologin.com")
	public URL kakaologin(){
		final String AUTH_HOST = "https://kauth.kakao.com";
	    final String tokenRequestUrl = AUTH_HOST + "/oauth/token";

	    String CLIENT_ID = "36cfa2b59a8f233978c8cacb43f38a1d"; // 해당 앱의 REST API KEY 정보. 개발자 웹사이트의 대쉬보드에서 확인 가능
	    String REDIRECT_URI = "http://211.183.0.19:8282/oauth"; // 해당 앱의 설정된 uri. 개발자 웹사이트의 대쉬보드에서 확인 및 설정 가능

	    HttpsURLConnection conn = null;
	    OutputStreamWriter writer = null;
	    BufferedReader reader = null;
	    InputStreamReader isr= null;

	    try {
	      final String params = String.format("grant_type=authorization_code&client_id=%s&redirect_uri=%s",
	                        CLIENT_ID, REDIRECT_URI);

	      final URL url = new URL(tokenRequestUrl);

	      conn = (HttpsURLConnection) url.openConnection();
	      conn.setRequestMethod("POST");
	      conn.setDoOutput(true);

	      writer = new OutputStreamWriter(conn.getOutputStream());
	      writer.write(params);
	      writer.flush();

	      final int responseCode = conn.getResponseCode();
	      System.out.println("\nSending 'GET' request to URL : " + tokenRequestUrl);
	      System.out.println("Post parameters : " + params);
	      System.out.println("Response Code : " + responseCode);

	      isr = new InputStreamReader(conn.getInputStream());
	      reader = new BufferedReader(isr);
	      final StringBuffer buffer = new StringBuffer();
	      String line;
	      while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	      }

	      return url;

	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	        // clear resources
	        if (writer != null) {
	          try {
	              writer.close();
	           } catch(Exception ignore) {
	           }
	        }
	        if (reader != null) {
	          try {
	              reader.close();
	          } catch(Exception ignore) {
	          }
	        }
	        if (isr != null) {
	            try {
	                isr.close();
	            } catch(Exception ignore) {
	            }
	         }
	    }
	
		return null;
	}
	@RequestMapping("/test.com")
	public String test(){
		
		return "test";
	}
	
}
