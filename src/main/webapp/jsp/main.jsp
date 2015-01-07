<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Gtook</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<!-- 
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
     -->
<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.css" />
<script src="./js/jquery.js"></script>
<script src="./dist/js/bootstrap.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="./js/login.js"></script>

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
				<a class="navbar-brand" href="redirect:/main.com">Gtook</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="userLogin"><a href="javascript:;"
						onclick="$('#login').modal('show', {backdrop: 'static'});">로그인</a></li>
					<li class="myPage"><a href="#">마이페이지</a></li>
					<li class="out"><a href="#">*탈퇴</a></li>
					<li></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="logout"><a href="#"> Log Out </a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
			<div class="navbar-collapse collapse"
				style="background-color: #19b96a;">
				<p id="userinfo" class="navbar-text pull-right" style="font-size: 18px;"></p>
			</div>
		</div>
	</div>

	<div class="well">
		<div class="row">
			<!-- facebook like&share-->
			<!-- facebook like&share-->

		</div>
	</div>

	<!-- 로그인 새창열기 -->
	<div class="modal fade" id="login" data-backdrop="static">
		<form id="login_ok" method="post" enctype="multipart/form-data"
			action="change_phone();">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">로그인</h4>
					</div>
					<div class="modal-body">
						<div class="panel-body">
							<!-- kakaotalk login -->
							<div id="kakao-login-btn"></div>
							<!-- kakaotalk login -->
							<!-- facebook -->
							

							<!-- facebook -->
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- 로그인 새창열기 -->


</body>



</html>