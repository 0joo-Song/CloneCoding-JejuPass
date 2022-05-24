package com.jejupass.web.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jejupass.web.user.dto.request.UserReqDto;
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
	public UserVO login(UserReqDto userReqDto) {
		return userMapper.login(userReqDto);
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
