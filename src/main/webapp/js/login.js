/**
 * 
 */

//facebook
 
//facebook
  Kakao.init('34aef3278c87c78eb00607f1705b149c');
  $(document).ready(function(){
	  var kakao_data;
	  Kakao.Auth.createLoginButton({
		    container: '#kakao-login-btn',
		    success: function(authObj) {
		      Kakao.API.request({
		        url: '/v1/user/me',
		        success: function(res) {
		          alert(JSON.stringify(res));
		        },
		        fail: function(error) {
		        	alert(JSON.stringify(error));
		        }
		      });
		    },
		    fail: function(err) {
		        alert(JSON.stringify(err))
		    }
		  });
	  //전송
  });
