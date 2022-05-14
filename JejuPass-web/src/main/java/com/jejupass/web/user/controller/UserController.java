package com.jejupass.web.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jejupass.common.constants.ResultCode;
import com.jejupass.common.utils.EncryptUtil;
import com.jejupass.web.user.dto.request.UserReqDto;
import com.jejupass.web.user.dto.response.UserRespDto;
import com.jejupass.web.user.vo.UserVO;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
    
	/**
	 * 로그인 페이지
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	 	public String loginPage(Model model, HttpServletRequest request) throws Exception {
	    	// 로그인 이전 페이지로 이동
		    // /user/login.do?prevPage='원래있던곳 api주소'
	    	String prevPage = request.getParameter("prevPage");
	    	log.info("prevPage====>" + prevPage);
	    		
	    	if(prevPage == null || prevPage == "") {
	    		prevPage = "/index.do";
	    	} 
	    	model.addAttribute("prevPage", prevPage);
	    	
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
 		
 		log.info("============ ODP USER LOGIN ============");
 		UserRespDto userRespDto = new UserRespDto();
 		
 		if(session.getAttribute("userLogin") != null) {
 			session.removeAttribute("userLogin");
 		}
 		
 		// 비밀번호 암호화
 		if(userReqDto.getUserPw().equals("-")) {
 			// 탈퇴한 회원의 비번은 암호화 하지 않고 '-' 값 그대로 설정
 			userReqDto.setEncPw(userReqDto.getUserPw());
 		} else {
 			userReqDto.setEncPw(EncryptUtil.encryptPW(userReqDto.getUserPw()));
 		}
 		/* 22-05-14 : dto다 완성되고 작업
 		userVO = userService.login(userReqDto);
 	
 		if(userVO != null) {
 			session.setAttribute("userLogin", userVO);		
 			// 마지막 로그인 시간 저장
 			userService.updateLastLoginDate(userVO);
 			
 			userRespDto.setResult(ResultCode.RESULT_SUCCESS.getCode());
 			userRespDto.setTempPwYn(userVO.getTempPwYn());
 			userRespDto.setUserSeq(userVO.getUserSeq());

 	    	
 		} else {
 			userRespDto.setResult(ResultCode.RESULT_FAIL.getCode());
 		}
 		*/
 		
 		return userRespDto;
 		
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
    
}
