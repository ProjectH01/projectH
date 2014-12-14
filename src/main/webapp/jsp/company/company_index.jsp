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
				 if($.trim($("#company_id").val())==""){
					 alert("관리자 아이디를 입력하세요!");
					 $("#company_id").val("").focus();
					 return false;
				 }
				 if($.trim($("#company_pwd").val())==""){
					 alert("관리자 비밀번호를 입력하세요!");
					 $("#company_pwd").val("").focus();
					 return false;
				 }
			 }
		</script>
	</head>
	<body>
		<div class="container">
			<form method="post" class="form-signin" action="company_login_ok.com" onsubmit="return company_check();">
				<h2 class="form-signin-heading">Sign in</h2>
					<input type="text" name="company_id" id="company_id" size="14" class="form-control" tabindex="1"
					placeholder="아이디"/>
					<input type="password" name="company_pwd" id="company_pwd" size="15" class="form-control" tabindex="2"
					placeholder="비밀번호"/>
				<div>
					<input type="submit" value="로그인" class="btn btn-lg btn-primary btn-block"/>
					<input type="button" value="회원가입" class="btn btn-lg btn-primary btn-block" 
					 onclick="location='company_join.com';"  />
				</div>
			</form>
		</div>
	</body>
</html>
