<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>

<!-- 임시데이터 -->
<form id="frm" name="frm" method="POST">
<div style="border:solid 1px black;width:60%;height:100px">
<input type="text" id="userId" name="reqData.userId" class="item-input" placeholder="아이디(이메일)" style="border:solid 1px black;"><br>
<p id="userIdEmailCheckMsg"></p><br>
<input type="password" onkeyup="enterkey();" id="userPw" name="reqData.userPw" class="item-input" placeholder="비밀번호" style="border:solid 1px black;"
autoComplete="off"><br>
<p id="userPwFailMsg"></p><br>
<button onclick="login()" style="background-color:#eeeeee">로그인</button>
</div>
</form>

<script type="text/javascript">

	// 엔터로 로그인
	function enterkey() {
	    if (window.event.keyCode == 13) {
	         login();
	    }
	}
	
	// 이메일이 잘못되었는지 확인하는 함수 

	function CheckEmail(str)
	{                                                 
	     var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	     if(!reg_email.test(str)) {       
	    	  $("#userIdEmailCheckMsg").text("이메일 형식이 맞지 않습니다.");
	          return false;         
	     }                            
	     else {              
	    	  $("#userIdFailMsg").text("");
	          return true;         
	     }                            
	}         
	
	// input 필수 값 유무에 따른 경고 메시지 유무
	function checkInput(inputId) {
		var nm = $('#'+inputId);
		var nmDiv = $('#'+inputId+"FailMsg");
		if (nm.val()=="") {
  			nmDiv.show();
			valueChk = false;
		} else {
			nmDiv.hide();
		}
	}
	
	var valueChk;
	function login() {
		valueChk = true;
		checkInput("userId");
		checkInput("userPw");

		if(valueChk) {
			var email = $("#userId").val();
			CheckEmail(email);
			
			$.ajax({
	            url: '/user/userLogin.do',
	            data: $("#frm").serialize(),
	            dataType: 'json',
	            method: 'POST',
	            success: function (data) {
	                if(data.result == "success"){
	                	var prevPage = '${prevPage}';
	                	if(data.tempPwYn == "Y") {
	                		alert("임시 비밀번호로 로그인했습니다. \n비밀번호를 변경해주세요.")
			                location.href="/user/modPw.do?prevPage="+prevPage;
		                } else {
		                	location.href = prevPage;	
				        }
		                var prevPage = '${prevPage}';
		               
		                		                
	                } else {
	                	$("#loginFailMsg").show();
	                }
	            },
	            error: function (e) {
	               alert(e);
	            }
	        });		
		}
  	}
	
	
</script>