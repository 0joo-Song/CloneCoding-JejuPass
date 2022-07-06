<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include/incDeclare.jsp" %>

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
                                    <input type="text" id="user_id">
                                    <button>중복확인</button>
                                </div>
                                <p id="emailFailMsg">이메일 형식이 맞지 않습니다. 다시 입력해 주세요.</p> <!--형식이 맞지않을 때 나타남-->
                            </div>
                            <div class="password_box">
                                <label for="user_password">아이디(이메일)</label>
                                <div class="password_check_box">
                                    <input type="password" id="user_password">
                                </div>
                                <p id="pwFailMsg">입력하신 비밀번호는 올바른 형식이 아닙니다.</p> <!--형식이 맞지않을 때 나타남-->
                            </div>
                            <div class="name_box">
                                <label for="user_name">아이디(이메일)</label>
                                <div class="name_check_box">
                                    <input type="text" id="user_name">
                                </div>
                            </div>
                            <div class="btd_box">
                                <span>생년월일</span>
                                <div class="btd_check_box">
                                    <input type="text" id="user_yeer">
                                    <input type="text" id="user_month">
                                    <input type="text" id="user_day">
                                </div>
                            </div>
                            <div class="num_box">
                                <label for="user_num">휴대폰번호</label>
                                <div class="num_check_box">
                                    <input type="tel" id="user_num">
                                </div>
                            </div>
                            <div class="sex_box">
                                <label for="user_sex">휴대폰번호</label>
                                <div class="sex_check_box">
                                    <div>
                                        <input type="radio" id="man" name="radSex">
                                        <label for="man">남자</label>
                                    </div>
                                    <div>
                                        <input type="radio" id="woman" name="radSex">
                                        <label for="woman">여자</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="button_box">
                            <button class="go_btn ok_btn">확인</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>