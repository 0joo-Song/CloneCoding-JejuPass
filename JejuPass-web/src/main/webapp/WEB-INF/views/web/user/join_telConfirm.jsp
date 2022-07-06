<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>
<div id="wrap" class="pass">
            <div class="container">
                <div id="sec01" class="sec01 section">
                    <div class="cont_wrap">
                        <div class="title_box">
                            <h1>본인인증</h1>
                            <h4>휴대폰 본인인증을 진행해 주세요.</h4>
                        </div>
                        <div class="button_box">
                            <button class="go_btn pass_btn" onclick="telConfirm()">인증하기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript">
        
        /*
        휴대폰인증 
        회원가입 데이터 잘 들어가는지 확인 후 작업
        */
        function telConfirm(){
        	location.href="/user/join_agree.do"
        }
        </script>