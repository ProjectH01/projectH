/**
 *  company_join
 */

//이메일 도메인 선택
 $(document).ready(function(){
	 $("#domain").change(function(){
		 $("#email_host").val($("#domain").val());
		 if($("#email_host").val()=="")
			 $("#email_host").focus();
	 })
 })
 
 function join_check(){
	 //비밀번호 확인
	 $company_pwd01=$.trim($("#company_pwd01").val());
	 $company_pwd02=$.trim($("#company_pwd02").val());
	 if($company_pwd01 != $company_pwd02){
			alert("비밀번호가 다릅니다!");
			$("#company_pwd01").val("");
			$("#company_pwd02").val("");
			$("#company_pwd01").focus();
			return false;
	 }
	 
	 //이메일+도메인
	 var email = $("#email_id").val()+"@"+$("#email_host").val()
	 $("#company_email").val(email);
	 	
 }