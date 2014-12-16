<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>이벤트 등록</title>
	</head>
	<body>
		<div class="page_container">
			<div class="sidebar_menu">
	
				<header class="logo_env">
					<div class="logo">
						<a href="company_main.com"> <img src="img/babitalk_logo.png"
							width="120" alt="" /></a>
					</div>
				</header>
	
				<ul id="main_menu" class="">
				<!-- Search Bar -->
				<li><a href="ask.php"><span>상담문의 관리</span>
				</a></li>
				<li><a href="company_event.com"><span>이벤트 관리</span>
				</a></li>
				<li><a href="charge.php"><span>충전금 관리</span>
				</a></li>
				<li><a href="javascript:;"
					onclick="$('#modal-3').modal('show', {backdrop: 'static'});"><span>상담번호 관리</span>
				</a></li>

				</ul>
			</div>
			
			<div class="main_content">
				<div class="row">
	
					<!-- Profile Info and Notifications -->
					<div>
	
						<ul class="user-info">
							<!-- Profile Info -->
							<li class="profile-info">
								<!-- add class "pull-right" if you want to place this from right -->
								<a href="#"> <img src="assets/images/thumb-1@2x.png" /> H의원
							</a>
	
							</li>
						</ul>
					</div>
					<!-- Raw Links -->
					<div>
						<ul>
	
							<li><span>&nbsp;충전금액:&nbsp;<b>780,000</b></span>원</li>
	
							<li><a href="company_logout.com"> Log Out </a></li>
	
						</ul>
					</div>
				</div>
				<form method="post" action="company_event_write_ok.com" onsubmit="return write_check();" enctype="multipart/form-data">
				<%-- 그림,동영상 같은 이진파일을  첨부해서 서버에 올리는 자료실  만들때 주의사항
				   1.반드시 form태그내에 enctype="multipart/form-data"속성을 지정해야 한다.
				   2.이진파일을 바이너리 파일이라고 한다. 이러한 파일을 서버로 보낼려면 반드시 method="post" 방식으로 넘겨야 한다.get은 안된다.
				   3.자바 웹개발에서 이진파일을 첨부해서 서버로 보낼려면 외부 라이브러리 파일이 필요하다. jsp 등 웹개발에서 광범위하게 사용되는대표적인 라이브러리 파일 cos.jar를 사용해 본다.
				   cos.jar는 바로 이진파일을 서버에서 받을수 있는 라이브러리.cos.jar말고 다른 이진 업로드 라이브러리파일이 다수 존재.
				 --%>
  					<table border="1">
   						<tr>
    						<th colspan="2">이벤트 등록</th>
   						</tr>
   						<tr>
    						<th>이벤트명</th>
    						<td>
    						<input name="event" id="event" size="14" />
    						</td>
   						</tr>
					   	<tr>
					    	<th>일반 배너이미지</th>
					    	<td>
					    	<input type="file" name="banner_image" />
					    	</td>
					   </tr>
					   <tr>
					    	<th>상세 이미지</th>
					    	<td>
					    	<input type="file" name="detail_image" />
					    	</td>
					   </tr>
					   <tr>
					   		<th>DB단가설정</th>
						    <td>
						    <input name="db_price" id="db_price" size="14"/>
						    </td>
					   </tr>
					   <tr>
					   		<th>카테고리 설정</th>
						    <td>
							    <select id="category">
	                              <option value="1">1</option>
	                              <option value="2">2</option>
	                              <option value="3">3</option>
	                              <option value="4">4</option>
	                              <option value="5">5</option>
	                              <option value="6">6</option>
	                           	</select>
						    </td>
					   </tr>
  					</table>
  					<div>
				  		<input type="submit" value="저장" class="input_b" />
				  		<input type="reset" value="취소" class="input_b" onclick="$('#event').focus();" />
				  		<input type="button" value="목록" class="input_b" onclick="location='company_event.com?page=${page}'" />
				 	</div>
 				</form>			
			</div>
		</div>
	</body>
</html>