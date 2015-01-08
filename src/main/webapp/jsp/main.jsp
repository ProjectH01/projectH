<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Gtook</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="./js/jquery.js"></script>
<script src="./dist/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="./css/gtook.css" />
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
				<a class="navbar-brand" href="redirect:/main.com">Gtook</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li id="siteLogin"><a href="javascript:;"
						onclick="$('#login').modal('show', {backdrop: 'static'});">로그인</a></li>
					<li id="userPage"><a href="mypage.com">마이페이지</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" id="Secession">탈퇴</a></li>
					<li id="mainlogout"><a href="#" id="MainLogout"> Log Out </a></li>
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

	<div id="carousel-example-generic" class="carousel slide">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>
 
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
    	<div class="container">
    		<img src="./images/mainimage.png" alt="..." style="width:100%; height:60%;">
    	</div>
    </div>
    <div class="item">
    	<div class="container">
       		<img src="./images/Koala.jpg" alt="..." style="width:100%; height:60%;">
       	</div>
    </div>
       <div class="item">
       	<div class="container">
      		<img src="./images/Lighthouse.jpg" alt="..." style="width:100%; height:60%;">
      	</div>
      </div>
  </div>
 
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
    <span class="icon-prev"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
    <span class="icon-next"></span>
  </a>
</div>
  <!-- END OF Wrapper for slides -->
  <div class="wrapper">
  <div class="content-main">
 <div class="panel panel-default">
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_01.png" alt="치과" />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_02.png" alt="안과"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_03.png" alt="눈/코성형"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_04.png" alt="보톡스/필터" />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_05.png" alt="뷰티주사"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_06.png" alt="피부과"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_07.png" alt="양악/안면윤곽"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_08.png" alt="동안성형/리프팅"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_09.png" alt="가슴성형"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_10.png" alt="지방흡입"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_11.png" alt="지방이식"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/01_12.png" alt="다이어트"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/2_05.png" alt="남자성형"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/2_06.png" alt="다리성형"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/2_07.png" alt="여성검진클리닉"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/2_08.png" alt="탈모/모발이식"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/2_09.png" alt="반영구시술"  />
  <input type="image" class="col-xs-4 col-sm-2 col-md-2 col-lg-1 selicon" src="./images/icon/2_10.png" alt="체험단" />
</div>
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