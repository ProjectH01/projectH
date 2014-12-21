<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 관리</title>
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
				<a class="navbar-brand" href="#">Project H</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">상담문의 관리</a></li>
					<li><a href="company_event.com">이벤트 관리</a></li>
					<li><a href="#">충전금 관리</a></li>
					<li><a href="javascript:;"
						onclick="$('#modal-3').modal('show', {backdrop: 'static'});">상담번호
							관리</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">환영합니다!<b>${id}</b>님&nbsp;충전금액:&nbsp;<b>${tcash}</b>원
					</a></li>
					<li><a href="company_logout.com"> Log Out </a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<div class="well">
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

			</div>

			<form action="company_event.com" onsubmit="return find_check();">
				<div class="">
					<a href="company_event_write.com" class="" type="button">이벤트 등록</a>
				</div>
				<br />
				<table id="event_list">
					<tr>
						<th style="width: 8%">상태</th>
						<th>시작일</th>
						<th style="min-width: 30%">이벤트명</th>
						<th class="hidden-xs">상담(건수)</th>
						<th class="hidden-xs">DB단가</th>
						<th style="width: 15%" class="hidden-xs">비고</th>
						<th style="width: 8%">중지</th>
					</tr>

					<c:if test="${!empty elist}">
						<c:forEach var="list" items="${elist}">
							<tr>
								<c:if test="${list.eve_state == 1}">
									<td align="center">광고중</td>
								</c:if>
								<c:if test="${list.eve_state == 0}">
									<td align="center">중지됨</td>
								</c:if>
								<td align="center">${list.eve_start_date}</td>
								<td><a href="company_event_edit.com?event=${list.event}">${list.event}</a></td>
								<td align="center">${list.cs_count}</td>
								<td align="center">${list.db_price}</td>
								<td align="center">${list.cs_note}</td>
								<td align="center">
									<c:if test="${list.eve_state == 1}">
										<a href="company_event_state_edit.com?event=${list.event}&eve_state=${list.eve_state}">중지</a>
									</c:if>
									<c:if test="${list.eve_state == 0}">
										<a href="company_event_state_edit.com?event=${list.event}&eve_state=${list.eve_state}">재광고</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</c:if>

					<c:if test="${empty elist}">
						<tr>
							<th colspan="5">이벤트가 없습니다!!</th>
						</tr>
					</c:if>

				</table>
			</form>
		</div>
	</div>
</body>
</html>