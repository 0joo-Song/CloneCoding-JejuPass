<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>

<input type="text" id="userId" name="userId" class="item-input" placeholder="아이디(이메일)">
<input type="password" onkeyup="enterkey();" id="userPw" name="userPw" class="item-input" placeholder="비밀번호">

<script type="text/javascript">

	// 엔터로 로그인
	function enterkey() {
	    if (window.event.keyCode == 13) {
	         login();
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