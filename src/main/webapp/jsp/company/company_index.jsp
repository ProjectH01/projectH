<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자 로그인</title>
		<link rel="stylesheet" type="text/css" href="./css/company.css" />
		<script src="./js/jquery.js"></script>
		<script>
			 function company_check(){
				 if($.trim($("#COMPANY_ID").val())==""){
					 alert("관리자 아이디를 입력하세요!");
					 $("#COMPANY_ID").val("").focus();
					 return false;
				 }
				 if($.trim($("#COMPANY_PWD").val())==""){
					 alert("관리자 비밀번호를 입력하세요!");
					 $("#COMPANY_PWD").val("").focus();
					 return false;
				 }
			 }
		</script>
	</head>
	<body>
		<form method="post" action="company_login_ok.com" onsubmit="return company_check();">
			<div class="login_form">
				<div id="login_id">
					<input type="text" name="COMPANY_ID" id="COMPANY_ID" size="14" class="input_box" tabindex="1"
					placeholder="아이디"/>
				</div>
				<div id="login_password">
					<input type="password" name="COMPANY_PWD" id="COMPANY_PWD" size="15" class="input_box" tabindex="2"
					placeholder="비밀번호"/>
				</div>
				<div>
					<input type="submit" value="로그인" class="input_s" />
				</div>
			</div>
		</form>
	</body>
</html>