package com.jejupass.web.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	Logger log = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * 메인 - 메인 페이지 이동
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index.do", method = { RequestMethod.GET, RequestMethod.POST })
		public String commError() throws Exception {
		return "web/index";
	}
}
