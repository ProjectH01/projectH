Kakao.init('34aef3278c87c78eb00607f1705b149c');
  $(document).ready(function(){
	  $('#custom-login-btn').click(function(){
		  Kakao.Auth.login({
		  		success : function(authObj) {
		  			// 로그인 성공시 API를 호출합니다.
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
	  
	  $('#test').click(function(){
		  alert(res);
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
			/*  $.ajax({
				  type:"POST"
				  ,url:"main.com" //세션 생성페이지 (setAttribute...)
				  ,data:"userId="+userId
				  ,success:function(){
				//성공하면...
					  alert("성공")
				   //location.href="http://localhost:8282/projectH/main.com?userId="+userId;   
				  }
				 });*/
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
		    	alert(" POINT "+data+"점   ");
		    	$('#userInfo').append(" POINT "+data+"점   ");
		    },
		    error:function(jqXHR, textStatus, errorThrown){
		        alert("에러 \n" + textStatus + " : " + errorThrown);
		        self.close();
		    }
		  })}; 
		  
		  
//facebook
	// This is called with the results from from FB.getLoginStatus().
	  function statusChangeCallback(response) {
	    console.log('statusChangeCallback');
	    console.log(response);
	    // The response object is returned with a status field that lets the
	    // app know the current login status of the person.
	    // Full docs on the response object can be found in the documentation
	    // for FB.getLoginStatus().
	    if (response.status === 'connected') {
	      // Logged into your app and Facebook.
	    	/*$.ajax({
	    		url : "somepath/login_ok",
	    		type : "POST",
	    		data : JSON.stringify(response),
	    		dataType : 'json',
	    		contentType : 'application/json;charset=UTF-8',
	    		success : function(){
	    			alert('전송성공');
	    		}, 
	    	 	error : function(){
	    	 		alert("에러 \n" + textStatus + " : " + errorThrown);
	    	 	      self.close();
	    	 	}
	    	});*/
	    	alert(JSON.stringify(response));  
	    } else if (response.status === 'not_authorized') {
	      // The person is logged into Facebook, but not your app.
	    } else {
	      // The person is not logged into Facebook, so we're not sure if
	      // they are logged into this app or not.
	    }
	  }

	  // This function is called when someone finishes with the Login
	  // Button.  See the onlogin handler attached to it in the sample
	  // code below.
	  function checkLoginState() {
	    FB.getLoginStatus(function(response) {
	      statusChangeCallback(response);
	    });
	  }

	  window.fbAsyncInit = function() {
	  FB.init({
	    appId      : '422534324580021',
	    cookie     : true,  // enable cookies to allow the server to access 
	                        // the session
	    xfbml      : true,  // parse social plugins on this page
	    version    : 'v2.1' // use version 2.1
	  });

	  // Now that we've initialized the JavaScript SDK, we call 
	  // FB.getLoginStatus().  This function gets the state of the
	  // person visiting this page and can return one of three states to
	  // the callback you provide.  They can be:
	  //
	  // 1. Logged into your app ('connected')
	  // 2. Logged into Facebook, but not your app ('not_authorized')
	  // 3. Not logged into Facebook and can't tell if they are logged into
	  //    your app or not.
	  //
	  // These three cases are handled in the callback function.

	  FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  });

	  };

	  // Load the SDK asynchronously
	  (function(d, s, id) {
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&appId=422534324580021&version=v2.0";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));

	 
//facebook
  });
