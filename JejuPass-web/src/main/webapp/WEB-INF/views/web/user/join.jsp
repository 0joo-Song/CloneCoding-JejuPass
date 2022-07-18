<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>
	<form id="frm" name="frm" >
	<input type="hidden" id="useAgree" name="reqData.useAgree" value="<c:out value="${data.useAgree }"/>">
	<input type="hidden" id="infoAgree" name="reqData.infoAgree" value="<c:out value="${data.useAgree }"/>">
	<input type="hidden" id="mktAgree" name="reqData.mktAgree" value="<c:out value="${data.useAgree }"/>">
 	<div id="wrap" class="join">
            <div class="container">
                <div id="sec01" class="sec01 section">
                    <div class="cont_wrap">
                        <div class="title_box">
                            <h1>회원가입</h1>
                        </div>
                        <div class="input_box">
                            <div class="id_box">
                                <label for="user_id">아이디(이메일)</label>
                                <div class="id_check_box">
                                    <input type="text" id="userId" name="reqData.userId" value="">
                                    <button type="button" onclick="checkDupId()">중복확인</button>
                                </div>
                                <p id="emailFailMsg" style="display:none;">이메일 형식이 맞지 않습니다. 다시 입력해 주세요.</p> <!--형식이 맞지않을 때 나타남-->
                            </div>
                            <div class="password_box">
                                <label for="user_password">비밀번호</label>
                                <div class="password_check_box">
                                    <input type="password" id="userPw" name="reqData.userPw" value="">
                                </div>
                                <p id="pwFailMsg" style="display:none;">입력하신 비밀번호는 올바른 형식이 아닙니다.</p> <!--형식이 맞지않을 때 나타남-->
                                <p id="pwFailMsg" style="display:none;">입력하신 비밀번호는 올바른 형식이 아닙니다.</p> <!--형식이 맞지않을 때 나타남-->
                            </div>
                            <div class="name_box">
                                <label for="user_name">이름</label>
                                <div class="name_check_box">
                                    <input type="text" id="userNm" name="userNm" value="">
                                </div>
                            </div>
                            <div class="btd_box">
                                <span>생년월일</span>
                                <input type="hidden" id="userBirth" name="reqData.userBirth" value="">
                                <div class="btd_check_box">
                                    <input type="text" id="userYear"  placeholder="YYYY" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength='4'>
                                    <input type="text" id="userMonth"  placeholder="MM" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength='2'>
                                    <input type="text" id="userDay" placeholder="DD" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength='2'>
                                </div>
                            </div>
                            <div class="num_box">
                                <label for="userTel">휴대폰번호</label>
                                <div class="num_check_box">
                                    <input type="tel" id="userTel" name="reqData.userTel"  oninput="autoHyphen(this)" maxlength="13" value="">
                                </div>
                            </div>
                            <div class="sex_box">
                                <label for="user_sex">성별</label>
                                <div class="sex_check_box">
                                    <div>
                                        <input type="radio" class="gender" id="male" name="reqData.userGender" value="m" checked>
                                        <label for="male">남자</label>
                                    </div>
                                    <div>
                                        <input type="radio" class="gender" id="female" name="reqData.userGender" value="f">
                                        <label for="female">여자</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="button_box">
                            <button class="go_btn ok_btn" type="button" onclick="userJoin()">확인</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        
     <script type="text/javascript">
     
     	// 휴대폰 번호 입력 정규식
     	const autoHyphen = (target) => {
    	 target.value = target.value
    	   .replace(/[^0-9]/g, '')
    	  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
    	}
        
  		// 이메일이 잘못되었는지 확인
	    function CheckEmail(str){     
	    	const reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	    	if(!reg_email.test(str)) {       
	    	    	  $("#userIdEmailCheckMsg").css("display","");
	    	    	  $("#userId").focus();
	    	    	  valueChk = false;
	    	}                            
	    	else {              
	    	    	 $("#userIdEmailCheckMsg").css("display","none");
	    	    	 valueChk = true;
	    	}                            
	    }      
	     
  		// 중복확인
  		function checkDubEmail(){
  			
  		}
  		
	    // input 필수 값 유무에 따른 경고 메시지 유무
  		let checkVal;
		function checkInput(inputId) {
			var nm = $("#"+inputId);
			if(nm.val() == ""){
				checkVal = false;
				// 공백 팝업 -> 임시로 alert
				
			}else{
				
			}
		}
	    
	    // 회원가입
	    function userJoin(){
	    	checkVal = true;
	    	// 생일 조합
	    	let userBirthday = $("#userYear").val() + $("#userMonth").val() + $("#userMonth").val();
	    	$("#userBirth").val(userBirthday);
	    	
	    	checkInput("userId");
	    	checkInput("userPw");
	    	checkInput("userNm");
	    	checkInput("userTel");
	    	checkInput("userBirth");
	    	checkInput("userGender");
	    	
	    	if(checkVal){
	    		alert("회원가입하자!")
	    	}else{
	    		alert("공백을 확인해주세요.");
	    	}
	    }
        </script>