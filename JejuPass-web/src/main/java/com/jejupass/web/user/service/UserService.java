package com.jejupass.web.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jejupass.common.constants.ResultCode;
import com.jejupass.common.utils.EncryptUtil;
import com.jejupass.web.user.dto.request.UserReqDto;
import com.jejupass.web.user.dto.response.UserRespDto;
import com.jejupass.web.user.mapper.UserMapper;
import com.jejupass.web.user.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	

	/**
	 * 회원 로그인
	 * @param userReqDto
	 * @return
	 */
	public UserRespDto userLogin(UserReqDto userReqDto, HttpSession session, UserVO userVO) {
 		UserRespDto resp = new UserRespDto();
 		
 		if(session.getAttribute("userLogin") != null) {
 			session.removeAttribute("userLogin");
 		}
 		
 		// 비밀번호 암호화
 		if(userReqDto.getReqData().getUserPw().equals("-")) {
 			// 탈퇴한 회원의 비번은 암호화 하지 않고 '-' 값 그대로 설정
 			userReqDto.getReqData().setEncPw(userReqDto.getReqData().getUserPw());
 		} else {
 			userReqDto.getReqData().setEncPw(EncryptUtil.encryptPW(userReqDto.getReqData().getUserPw()));
 		}
 		
 		userVO = userMapper.login(userReqDto);
 	
 		if(userVO != null) {
 			session.setAttribute("userLogin", userVO);		
 			// 마지막 로그인 시간 저장
 			userMapper.updateLastLoginDate(userVO);
 			
 			resp.setResult(ResultCode.RESULT_SUCCESS.getCode());
 			resp.getRespData().setTempPwYn(userVO.getTempPwYn());
 			resp.getRespData().setUserSeq(userVO.getUserSeq());
 	    	
 		} else {
 			resp.setResult(ResultCode.RESULT_FAIL.getCode());
 		}
 		
		return resp;
	}

	/**
	 * 마지막 로그인 시간 저장
	 * @param userVO
	 */
	public void updateLastLoginDate(UserVO userVO) {
		
	}

	/**
	 * 아이디 중복 확인
	 * @param userReqDto
	 * @return
	 */
	public int selectDupUserId(UserReqDto userReqDto) {
		return userMapper.selectDupUserId(userReqDto);
	}




	

}
