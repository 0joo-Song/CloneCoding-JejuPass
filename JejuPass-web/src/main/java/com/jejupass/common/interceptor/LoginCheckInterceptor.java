package com.jejupass.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jejupass.web.user.vo.UserVO;

// import com.skict.web.member.vo.MemberVO;

//로그인처리를 담당하는 인터셉터
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("=================================================================");
		log.info("===================== WEB BEGIN INTERCEPTOR =====================");
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * 60 * 24);
		Object obj = (UserVO) session.getAttribute("userLogin");
		
		if (obj == null) {
			response.sendRedirect("/index.do");
			return false;
		}
		
		return true;
	}

}
