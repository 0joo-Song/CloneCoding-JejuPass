package com.jejupass.web.about.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

	Logger log = LoggerFactory.getLogger(AboutController.class);
	
	/**
	 * jejupass - 회사소개
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/about/jejupass.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String aboutJejuPass() throws Exception {
		log.info("/ aboutJejuPass /");
        return "web/about/jejupass";
    }
}
