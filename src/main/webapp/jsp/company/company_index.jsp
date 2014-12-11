<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>관리자 로그인</title>
		<!--  Bootstrap core CSS -->
		<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.css"/>
		<!-- Custom CSS -->
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
		<div class="container">
			<form method="post" class="form-signin" action="company_login_ok.com" onsubmit="return company_check();">
				<h2 class="form-signin-heading">Sign in</h2>
					<input type="text" name="COMPANY_ID" id="COMPANY_ID" size="14" class="form-control" tabindex="1"
					placeholder="아이디"/>
					<input type="password" name="COMPANY_PWD" id="COMPANY_PWD" size="15" class="form-control" tabindex="2"
					placeholder="비밀번호"/>
				<div>
					<input type="submit" value="로그인" class="btn btn-lg btn-primary btn-block" />
				</div>
			</form>
		</div>
	</body>
</html>
