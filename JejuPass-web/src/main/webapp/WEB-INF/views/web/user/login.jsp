<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>
	
	<form id="frm" name="frm" method="POST">
    <div id="sec01" class="sec01 section">
                    <div class="cont_wrap">
                        <div class="login_cont">
                            <div class="id_box">
                                <label for="user_id">아이디(이메일)</label>
                                <input type="text" name="reqData.userId" id="userId" placeholder="E-mail을 입력해주세요.">
                            </div>
                            <div class="psw_box">
                                <label for="user_pw">비밀번호</label>
                                <input type="password" onkeyup="enterkey();" name="reqData.userPw" id="userPw" placeholder="비밀번호를 입력해주세요.">
                            </div>
                            <div class="check_box">
                                <input type="checkbox" name="lg_ck" id="lg_ck">
                                <label for="lg_ck">로그인 유지</label>
                                <input type="checkbox" name="user_id_ck" id="user_id_ck">
                                <label for="id_ck">아이디 저장</label>
                            </div>
                            <div class="button_box">
                                <button class="login_btn" onclick="login()">로그인</button>
                                <a href="#">아이디 찾기</a>
                                <a href="#">비밀번호 찾기</a>
                                <a href="#">회원가입</a>
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