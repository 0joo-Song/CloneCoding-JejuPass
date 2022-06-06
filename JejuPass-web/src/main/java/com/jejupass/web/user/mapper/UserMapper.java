package com.jejupass.web.user.mapper;

import com.jejupass.web.user.dto.request.UserReqDto;
import com.jejupass.web.user.vo.UserVO;

public interface UserMapper {

	UserVO selectUserLogin(UserReqDto userReqDto);

	int selectDupUserId(UserReqDto userReqDto);

	void updateLastLoginDate(UserVO userVO);

}
