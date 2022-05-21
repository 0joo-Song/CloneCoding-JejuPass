package com.jejupass.web.event.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jejupass.web.user.controller.UserController;

@Controller
public class EventController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);

	/*
	 * 진행중인 이벤트
	 */
	@RequestMapping(value="/event/eventProgress.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String eventProgress(Model model) {
        model.addAttribute("data", "eventService 작업");
        return "web/event/progressEvent"; 
    }
	
	/*
	 * 종료된 이벤트
	 */
	@RequestMapping(value="/event/eventComplete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String eventComplete(Model model) {
        model.addAttribute("data", "eventService 작업");
        return "web/event/completeEvent"; 
    }
	
	/*
	 * 담청자 발표
	 */
	@RequestMapping(value="/event/eventWinner.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String eventWinner(Model model) {
        model.addAttribute("data", "eventService 작업");
        return "web/event/eventWinner"; 
    }
}
