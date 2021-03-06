package com.jejupass.web.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jejupass.web.user.dto.request.UserReqDto;
import com.jejupass.web.user.dto.response.UserRespDto;
import com.jejupass.web.user.service.UserService;
import com.jejupass.web.user.vo.UserVO;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
    
	@Resource(name="userService")
	private UserService userService;	
	
	/**
	 * 로그인 페이지
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	 	public String loginPage(Model model, HttpServletRequest request ) throws Exception {
	    	// 로그인 이전 페이지로 이동
		    // /user/login.do?prevPage='원래있던곳 api주소'
			/*
	    	String prevPage = request.getParameter("prevPage");
	    	log.info("prevPage====>" + prevPage);
	    		
	    	if(prevPage == null || prevPage == "") {
	    		prevPage = "/index.do";
	    	} 
	    	model.addAttribute("prevPage", prevPage);
	    	*/
	    	
	 		return "web/user/login";
	}
	
	/**
	 * 로그인
	 * @param userReqDto
	 * @param session
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
 	@RequestMapping(value="/user/userLogin.do", method = {RequestMethod.GET, RequestMethod.POST})
 	public UserRespDto userLogin(UserReqDto userReqDto, HttpSession session, UserVO userVO) throws Exception {
 		UserRespDto resp = userService.userLogin(userReqDto, session, userVO);
 		return resp;
    }
   
    /**
     * 로그아웃
     * @param session
     * @return
     */
    @RequestMapping(value="/user/logout.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session) {
     	// 세션 초기화
        session.invalidate(); 
        return "redirect:/index.do"; 
    }
    
    /**
     * 회원가입 - step 1 : 휴대폰 인증
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user/join_telConfirm.do", method = {RequestMethod.GET, RequestMethod.POST})
 	public String join_telConfirm(Model model) throws Exception {
 		return "web/user/join_telConfirm";
    }	
    
    
    /**
     * 회원가입 - step 2 : 개인정보 동의 
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user/join_agree.do", method = {RequestMethod.GET, RequestMethod.POST})
 	public String join_agree(Model model, UserReqDto userReqDto) throws Exception {
    	model.addAttribute("data", userReqDto.getReqData());
 		return "web/user/join_agree";
    }	
    
    /**
     * 회원가입 - step 3 : 회원정보 입력
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user/join.do", method = {RequestMethod.GET, RequestMethod.POST})
 	public String join(Model model, UserReqDto userReqDto) throws Exception {
    	model.addAttribute("reqData", userReqDto);
    	System.out.println(userReqDto.getReqData().getInfoAgree());
 		return "web/user/join";
    }	
    
    
    /**
     * 회원가입
     * @param userReqDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user/joinUser.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String join(UserReqDto userReqDto) throws Exception {
    	/*
    	//비밀번호 암호화
    	userReqDto.setEncPw(EncryptUtil.encryptPW(userReqDto.getUserPw()));
    	userReqDto.setUserApiKey(EncryptUtil.encryptSHA256(userReqDto.getUserId()+StringUtil.getRandomString(4, "T"))); // User Api Key 추가 
    	userService.insertUser(userReqDto);
    	*/
    	
    	// OAuth 인증 정보 생성 
    	//oauthProcService.createUserOAuth(userReqDto);
    	log.info("userReqDto=>>"+userReqDto);
    	
    	
        return "web/user/joinResult";
    }
    
    /**
     * 이메일 중복 체크 및 인증코드 보내기
     * @param userReqDto
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/user/checkDupEmail.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String checkDupEmail(UserReqDto userReqDto, HttpServletRequest request) throws Exception {
    	log.info("check dup email => "+userReqDto);
    	String result = null;
    	int cnt = userService.selectDupUserId(userReqDto);
    	/*
    	if (cnt == 0) {
    		// 이메일로 인증보드 보내기
    		MailInfoVO mailInfoVO  = MailInfoVO.builder()
    				.emailType(EmailType.EMAIL_AUTH)
    				.rcvMailAddress(userReqDto.getUserId().toString())
    				.authCode(StringUtil.getRandomString(6, "N"))
    				.emailFormPath(request.getSession().getServletContext().getRealPath("/mail"))
    				.build();
        	// 메일보내기
        	mailService.mailSend(mailInfoVO);
        	
        	// 인증코드 테이블 저장
        	userService.insertAuthCode(mailInfoVO);
        	
        	result = ResultCode.RESULT_SUCCESS.getCode();
        	
    	} else {
    		result = ResultCode.RESULT_FAIL.getCode();
    	}
    	*/
        return result;
    }
    
    /**
     * 인증번호 확인
     * @param userReqDto
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/user/checkAuthCode.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String checkAuthCode(UserReqDto userReqDto) throws Exception {
    	String result = null;
    	/*
    	int cnt = userService.selectAuthCode(userReqDto);
    	
    	if(cnt == 1) {
    		result = ResultCode.RESULT_SUCCESS.getCode();
    	} else {
    		result = ResultCode.RESULT_FAIL.getCode();
    	}
    	*/
    	
        return result;
    }
}
