package com.jejupass.web.comm.controller;

import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CommController {
	Logger log = LoggerFactory.getLogger(CommController.class);


	@RequestMapping(value="/comm/error.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String commError(Model model) throws Exception {
		
		return "blank:admin/comm/error";
    }    
}
