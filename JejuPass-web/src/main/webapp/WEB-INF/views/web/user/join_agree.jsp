<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>
<form id="frm" name="frm" action="/user/join.do" method="POST">
<div id="wrap" class="agree">
            <div class="container">
                <div id="sec01" class="sec01 section">
                    <div class="cont_wrap">
                        <div class="title_box">
                            <h1>약관동의</h1>
                            <h4>약관 및 정보이용 안내에 동의해주세요.</h4>
                        </div>
                        <div class="agree_box">
                            <div class="all_agree">
                                <input type="checkbox" id="all_ch">
                                <label for="all_ch">전체 약관 동의</label>
                            </div>
                            <div class="check_box">
                                <div class="check_1 ch_div">
                                    <input type="checkbox" name="reqData.useAgree" id="check_01" value="N">
                                    <label for="check_01">[필수]이용약관 동의</label>
                                </div>
                                <div class="check_2 ch_div">
                                    <input type="checkbox" name="reqData.infoAgree" id="check_02" value="N">
                                    <label for="check_02">[필수]개인정보 취급방침 동의</label>
                                </div>
                                <div class="selec_ch ch_div">
                                    <input type="checkbox" name="reqData.mktAgree" id="check_03" value="N">
                                    <label for="check_03">[선택]마케팅 및 광고 활용 동의</label>
                                </div>
                            </div>
                            <p class="info_text">&middot; 수신 동의 시 제주도 여행 노하우가 담긴 뉴스레터와 이벤트 소식을 알려드립니다. 예약 관련 내용은 동의 여부와 관계없이 발송됩니다.</p>
                        </div>
                        <div class="button_box">
                            <button class="go_btn agree_btn" type="button" onclick="goJoinPage();">동의하고 가입하기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </form>  
        <script type="text/javascript">
        
        $(document).ready(function() {
        	
        	//전체 동의
        	$("#all_ch").change(function(){
        		if($("#all_ch").is(":checked")){
	        		$('input[id^="check_"]').each((index, item) => {
	        		    $(item).prop("checked", true);
	        		    $(item).val("Y");
	        		});
        		}else{
        			$('input[id^="check_"]').each((index, item) => {
	        		    $(item).prop("checked", false);
	        		    $(item).val("N");
	        		});
        		}
        	});
        	$(".ch_div").change(function(){
        		alert($('.ch_div').length+" | "+$('input[class="ch_div"]:checked').length);
	        	if($('input[class="ch_div"]:checked').length == $('.ch_div').length){ 
	               $('#all_ch').prop('checked',true);     
	       		}else{       
	       			$('#all_ch').prop('checked',false);     
	       		}
        	})
		});
        
        let checkVal;
        function inputCheck(id){
        	if($("#check_"+id).is(":checked")){
        		$("#check_"+id).val("Y");
        	}else{
        		$("#check_"+id).val("N");
        		checkVal = false;
        	}
        }
        
        // 체크 값 확인
        function goJoinPage(){
        	checkVal = true;
        	inputCheck("01");
        	inputCheck("02");
        	if(checkVal){
        		alert("성공")
        		$("#frm").submit();	
        	}else{
        		alert("필수 약관에 동의해주세요.");
        		return false;
        	}
        	
        	//location.href="/user/join.do"
        }
        </script>