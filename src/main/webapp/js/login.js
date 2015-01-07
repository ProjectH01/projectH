Kakao.init('34aef3278c87c78eb00607f1705b149c');
  $(document).ready(function(){
	  $('#custom-login-btn').click(function(){
		  Kakao.Auth.login({
		  		success : function(authObj) {
		  			Kakao.API.request({
		  				url : '/v1/user/me',
		  				success : function() {
		  					location.href="http://localhost:8080/projectH/main.com";
		  				},
		  				fail : function() {
		  					alert("다시 로그인해주세요");
		  				}
		  			});
		  		},
		  		fail : function(err) {
		  			alert("다시 로그인해주세요");
		  		}
		  	})//login
	  });//버튼 클릭
	 
	  $('#MainLogout').click(function(){
		  Kakao.Auth.logout();
		  	location.href="http://localhost:8080/projectH/main.com";
	  });
	  
	  Kakao.Auth.getStatus(function(statusObj){
		  if(statusObj.status=="connected"){
			  $('#custom-login-btn').hide();
			  $('#mainlogout').show();
			  $('#Secession').show();
			  $('#userPoint').show();
			  $('#userPage').show();
			  $('#siteLogin').hide();
			  //kakao API 불러오기
			  Kakao.API.request({
	  				url : '/v1/user/me',
	  				success : function(res) {
	  					var nickname = res.properties.nickname;
	  					var thumbnail_image = res.properties.thumbnail_image;
	  					var profile_image = res.properties.profile_image;
	  					/*var res = JSON.stringify(res);*/
	  					var userIn = " 환영합니다 "+nickname+"님   ";
	  					$('#userInfo').append($(document.createElement('img')).attr({
	  						src:profile_image,
	  						style:"width:38px; height:38px; border-radius:30px;"
	  					}));
	  					$('#userInfo').append($(document.createElement('span')).attr({
	  						id:name,
	  						style:"font-weight:bold;"
	  					}).text(userIn));
	  					open_url("main_ok.com",res);//ajax
	  				},
	  				fail : function(error) {
	  					alert("다시 로그인해주세요");
	  				}
	  			});
			  //ajax쓸곳
		  }else{
			  $('#custom-login-btn').show();
			  $('#userPage').hide();
			  $('#siteLogin').show();
			  $('#mainlogout').hide();
			  $('#Secession').hide();
			  $('#userPoint').hide();
		  }//if문
		 });
	  //전송
	  function open_url( url, data){ 
		  $.ajax({ 	
		    type: "POST", 
		    url: url, 
		    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		    data: data,
		    success: function(data){ 
		    	$('#userInfo').append(" POINT "+data+"점   ");
		    },
		    error:function(jqXHR, textStatus, errorThrown){
		        alert("에러 \n" + textStatus + " : " + errorThrown);
		        self.close();
		    }
		  })}; 
		  
  });
