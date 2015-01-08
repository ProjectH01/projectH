<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Gtook</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="./css/gtook.css" />
<script src="./js/jquery.js"></script>
<script src="./dist/js/bootstrap.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="./js/login.js"></script>
<script>
	
</script>
</head>
<body>
	<div class="container">
		<div class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand hidden-xs" href="main.com">Gtook</a>
				<p class="navbar-brand visible-xs pageTitle">마이페이지</p>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="main.com">Home</a></li>
					<li id="siteLogin"><a href="javascript:;"
						onclick="$('#login').modal('show', {backdrop: 'static'});">로그인</a></li>
					<li id="userPage"><a href="#">마이페이지</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" id="Secession">탈퇴</a></li>
					<li id="mainlogout"><a href="logout.com" id="MainLogout"> Log Out </a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
			<div class="navbar-collapse collapse"
				style="background-color: #19b96a;">
				<ul class="nav nav-pills">
					<li id="userInfo" class="navbar-text pull-right"
						style="font-size: 16px;"></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="well">
		<div class="row">
		<p>잘못된 접근입니다</p>
		<p>로그인을 하세요</p>
		</div>
	</div>

	<!-- 로그인 새창열기 -->
	<div class="modal fade" id="login" data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
				</div>
				<div class="modal-body">
					<div class="panel-body">
						<!-- kakaotalk login -->
						<a href="#" id="custom-login-btn"> <img
							src="./images/kakao_account.png"></img>
						</a> <br />
						<!-- kakaotalk login -->
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>

	</div>
	<!-- 로그인 새창열기 -->
</body>



</html>