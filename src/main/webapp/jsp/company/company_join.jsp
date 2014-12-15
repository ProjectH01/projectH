<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관리자 가입</title>
		<script src="././js/jquery.js"></script>
		<script src="././js/company_join.js"></script>
	</head>
	<body>
		<div id="join_wrap">
  			<h2 class="join_title">관리자 가입</h2>
  				<form method="post" action="company_join_ok.com" onsubmit="return join_check();">
    				<table id="join_t">
     					<tr>
      						<th>관리자 아이디</th>
      						<td>
      						<input type="text" name="company_id" id="company_id" size="14" class="box" required/>
      						</td>
     					</tr>
     					<tr>
      						<th>상호명</th>
      						<td>
      						<input type="text" name="company_name" id="company_name" size="14" class="box" required/>
      						</td>
     					</tr>
     					<tr>
      						<th>관리자 비밀번호</th>
      						<td>
						    <input type="password" name="company_pwd" id="company_pwd01" size="14" class="box" required/>
						    </td>
     					</tr>
     					<tr>
      						<th>관리자 비밀번호 확인</th>
      						<td>
						    <input type="password" name="company_pwd02" id="company_pwd02" size="14" class="box" required/>
						    </td>
     					</tr>
     					<tr>
     						<th>관리자 이메일</th>
     						<td>
                           	<input type="hidden" name="company_email" id="company_email"> 
                           	<input id="email_id" type="text" required style="width: 150px;"> @ <input id="email_host" type="text" required style="width: 150px;">
                           	<select id="domain">
                              <option value="">- 이메일 선택 -</option>
                              <option value="gmail.com">gmail.com</option>
                              <option value="naver.com">naver.com</option>
                              <option value="hanmail.net">hanmail.net</option>
                              <option value="nate.com">nate.com</option>
                              <option value="">직접입력</option>
                           	</select>
                        </td>
     					</tr>
     					<tr>
     						<th>관리자 전화상담번호</th>
     						<td>
     						<input name="company_phone" id="company_phone" size="30" class="box" required/>
     						</td>
     					</tr>
     					<tr>
     						<th>관리자 문자상담번호</th>
     						<td>
     						<input name="company_letter" id="company_letter" size="30" class="box" required/>
     						</td>
     					</tr>
     					<tr>
     						<th>관리자 계좌번호</th>
     						<td>
     						<input name="company_cash_num" id="company_cash_num" size="30" class="box" required/>
     						</td>
     					</tr>
     				</table>
     				<div id="join_menu">
    					<input type="submit" value="가입" class="input_b" />
    					<input type="reset" value="취소" class="input_b" onclick="$('#company_id').focus();" />
    				</div>
     			</form>
     		</div>
	</body>
</html>