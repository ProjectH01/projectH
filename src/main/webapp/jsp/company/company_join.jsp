<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>관리자 가입</title>
		<script src="././js/jquery.js"></script>
		<script src="././js/company_join.js"></script>
		<!--  Bootstrap core CSS -->
		<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap-theme.css"/>
		<!-- Custom CSS -->
		<link rel="stylesheet" type="text/css" href="./css/company.css" />
	</head>
	<body>
	<div class="container">
		<div class="jumbotron">
  			<h2>관리자 가입</h2>
  				<form method="post" role="form" action="company_join_ok.com" onsubmit="return join_check();">
    				<div class="form-group">
      					<label for="inputid">관리자 아이디</label>
      					<input type="text" name="company_id" id="company_id" size="14" class="form-control" required/>
      				</div>
      				<div class="form-group">
      					<label for="inputcompany">상호명</label>
      					<input type="text" name="company_name" id="company_name" size="14" class="form-control" required/>
      				</div>
      				<div class="form-group">
      						<label for="inputpwd">관리자 비밀번호</label>
						    <input type="password" name="company_pwd" id="company_pwd01" size="14" class="form-control" required/>
					</div>
    				<div class="form-group">
      						<label for="inputrepwd">관리자 비밀번호 확인</label>
						    <input type="password" name="company_pwd02" id="company_pwd02" size="14" class="form-control" required/>
					</div>
  						<div class="form-inline">
  						<label for="inputemail">관리자 이메일</label>			
                           	<input type="hidden" name="company_email" id="company_email"> 
                           	<input id="email_id" type="text" required style="width: 150px;" class="form-control"> @ <input id="email_host" type="text" required style="width: 150px;" class="form-control">
                           	<select id="domain" class="form-control">
                              <option value="">- 이메일 선택 -</option>
                              <option value="gmail.com">gmail.com</option>
                              <option value="naver.com">naver.com</option>
                              <option value="hanmail.net">hanmail.net</option>
                              <option value="nate.com">nate.com</option>
                              <option value="" class="direct">직접입력</option>
                           	</select>
						</div>
					<div class="form-group">					
     						<label for="inputphone">관리자 전화상담번호</label>
     						<input name="company_phone" id="company_phone" size="30" class="form-control" required/>
     				</div>
					<div class="form-group">					     				
     						<label for="inputletter">관리자 문자상담번호</label>
     						<input name="company_letter" id="company_letter" size="30" class="form-control" required/>
					</div>
					<div class="form-group">					
     						<label for="inputCashNum">관리자 계좌번호</label>
     						<input name="company_cash_num" id="company_cash_num" size="30" class="form-control" required/>
     				</div>
     				<div id="form-group">
    					<input type="submit" value="가입" class="btn btn-primary btn-sm" />
    					<input type="reset" value="취소" class="btn btn-default btn-sm" onclick="$('#company_id').focus();" />
    					<input type="button" value="로그인화면으로" class="btn btn-default btn-sm" onclick="location='company_index.com';" />
    				</div>
     			</form>
     		</div>
     	</div>
	</body>
</html>