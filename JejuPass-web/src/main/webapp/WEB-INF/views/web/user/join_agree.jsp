<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>
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
                                <input type="checkbox" name="" id="all_ch">
                                <label for="all_ch">전체 약관 동의</label>
                            </div>
                            <div class="check_box">
                                <div class="check_1 ch_div">
                                    <input type="checkbox" id="ch_1">
                                    <label for="ch_1">[필수]이용약관 동의</label>
                                </div>
                                <div class="check_2 ch_div">
                                    <input type="checkbox" id="ch_2">
                                    <label for="ch_2">[필수]개인정보 취급방침 동의</label>
                                </div>
                                <div class="selec_ch ch_div">
                                    <input type="checkbox" name="" id="sel_ch">
                                    <label for="sel_ch">[선택]마케팅 및 광고 활용 동의</label>
                                </div>
                            </div>
                            <p class="info_text">&middot; 수신 동의 시 제주도 여행 노하우가 담긴 뉴스레터와 이벤트 소식을 알려드립니다. 예약 관련 내용은 동의 여부와 관계없이 발송됩니다.</p>
                        </div>
                        <div class="button_box">
                            <button class="go_btn agree_btn" onclick="goJoinPage();">동의하고 가입하기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript">
        
        // 체크 값 확인
        function goJoinPage(){
        	
        	
        	location.href="/user/join.do"
        }
        </script>