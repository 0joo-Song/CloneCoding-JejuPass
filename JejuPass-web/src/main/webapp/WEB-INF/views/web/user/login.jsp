<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>

<form id="frm" name="frm" method="POST">
	<div id="sec01" class="sec01 section">
		<div class="cont_wrap">
			<div class="login_cont">
				<div class="id_box">
					<label for="user_id">아이디(이메일)</label>
					<input type="text" id="userId" name="reqData.userId" placeholder="E-mail을 입력해주세요.">
					<p id="userIdEmailCheckMsg" style="display:none;">이메일 형식이 맞지 않습니다.</p>
				</div>
				<div class="psw_box">
					<label for="user_pw">비밀번호</label>
					<input type="password" onkeyup="enterkey();" id="userPw" name="reqData.userPw" 
					autoComplete="off" placeholder="비밀번호를 입력해주세요.">
					<p id="userPwCntCheckMsg" style="display:none;">최소 8자 이상 입력해주세요.</p>
				</div>
				<div class="check_box">
					<input type="checkbox" name="lg_ck" id="lg_ck"> <label
						for="lg_ck">로그인 유지</label> <input type="checkbox" id="user_id_ck">
					<label for="user_id_ck">아이디 저장</label>
				</div>
				<div class="button_box">
					<button type="button" class="login_btn" onclick="login()">로그인</button>
					<a class="find_btn find_btn_1" href="#">아이디 찾기</a> 
					<a class="find_btn find_btn_2" href="#">비밀번호 찾기</a>
					<a class="find_btn find_btn_3" href="#">회원가입</a>
				</div>
			</div>
		</div>
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
	function CheckEmail(str){                                                 
	     const reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	     if(!reg_email.test(str)) {       
	    	  document.getElementById('userIdEmailCheckMsg').style.display = 'block';
	    	  valueChk = false;
	     }                            
	     else {              
	    	 document.getElementById('userIdEmailCheckMsg').style.display = 'none';
	     }                            
	}         
	
	// input 필수 값 유무에 따른 경고 메시지 유무
	function checkInput(inputId) {
		let nm = document.getElementById(inputId);
		if(nm.value == ""){
			valueChk = false;
			// 공백 팝업 -> 임시로 alert
			alert("공백을 확인해주세요.");
			return;
		}else{
			
		}
	}
	
	// 로그인
	let valueChk;
	function login(){
		valueChk = true;
		checkInput("userId");
		checkInput("userPw");

		const email = document.getElementById('userId').value;
		CheckEmail(email);
		if(valueChk) {
			
			$.ajax({
	            url: '/user/userLogin.do',
	            data: $("#frm").serialize(),
	            dataType: 'json',
	            method: 'POST',
	            success: function (data) {
	                if(data.result == "success"){
	                	if(data.tempPwYn == "Y") {
	                		// 비밀번호 변경 페이지로 이동
		                } else {
		                	alert("로그인 성공");
				        }
	                } else {
	                	alert("로그인 실패");
	                }
	            },
	            error: function (e) {
	               alert(e);
	            }
	        });		
		}
  	}
	
	
</script>