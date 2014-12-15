<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>이벤트 관리</title>
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
			
			<div class="">
  				<a href="company_event_write.com" class="" type="button">이벤트 등록</a>
			</div>
			<br />
			<table id="event_list">
				<tr>
					<th style="width:8%">상태</th>
					<th>시작일</th>
					<th style="min-width:30%">이벤트명</th>
					<th class="hidden-xs">상담(건수)</th>
					<th class="hidden-xs">DB단가</th>
					<th style="width:15%" class="hidden-xs">비고</th>
					<th style="width:8%">중지</th>
				</tr>
				
				
			</table>
			</div>
		</div>
	</body>
</html>