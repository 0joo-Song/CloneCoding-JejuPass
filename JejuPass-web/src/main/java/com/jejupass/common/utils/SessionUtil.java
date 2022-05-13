package com.jejupass.common.utils;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jejupass.web.user.vo.UserVO;

/**
 * 세션 처리
 * @author rain
 *
 */
public class SessionUtil {

	// 로그인 유저 VO 가져오기
	public static UserVO getCurrentAdminVO() {
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
		return (UserVO) httpSession.getAttribute("userLogin");
	}

	// 로그인 유저 아이디 가져오기
	public static String getCurrentUserId() {
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
		return ((UserVO) httpSession.getAttribute("userId")).getUserId();
	}

}
