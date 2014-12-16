<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
<link rel="stylesheet" type="text/css" href="./css/company_main.css" />
</head>
<body>
	<div class="page_container">
		<div class="sidebar_menu">

			<header class="logo_env">
				<div class="logo">
					<a href="company_main.com"></a>
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

					<ul class="user_info">
						<!-- Profile Info -->
						<li class="profile_info">
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


			<div class="row">
				<ul>
					<li>
						<div class="col-sm-3">
							<a>
								<div>
									<div>0</div>
									<h3>광고중인 이벤트</h3>
									<p></p>
								</div>
							</a>
						</div>
					</li>
					<li>
						<div class="col-sm-3">
							<a>
								<div>
									<div>0</div>
									<h3>이벤트 상담요청</h3>
									<p></p>
								</div>
							</a>
						</div>
					</li>
					<li>
						<div class="col-sm-3">
							<a href="#">
								<div>
									<div>0</div>
									<h3>현재 충전금액</h3>
									<p></p>
								</div>
							</a>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>