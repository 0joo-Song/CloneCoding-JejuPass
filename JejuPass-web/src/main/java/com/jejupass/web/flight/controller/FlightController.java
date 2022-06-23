package com.jejupass.web.flight.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jejupass.web.flight.dto.request.FlightReqDto;
import com.jejupass.web.flight.dto.response.FlightRespDto;
import com.jejupass.web.flight.service.FlightService;

@Controller
public class FlightController {
Logger log = LoggerFactory.getLogger(FlightController.class);
    
	@Resource(name="flightService")
	private FlightService flightService;	
	
	@ResponseBody
 	@RequestMapping(value="/flight/srchFlight.do", method = {RequestMethod.GET, RequestMethod.POST})
 	public FlightRespDto srchFlight(FlightReqDto flightReqDto, HttpSession session) throws Exception {
		System.out.println("controller 확인");
		flightReqDto.setSchDate("20220621");
		flightReqDto.setSchDeptCityCode("GMP");
		flightReqDto.setSchArrvCityCode("PUS");
		
		FlightRespDto resp = flightService.srchFilghtList(flightReqDto);
 		return resp;
    }
	
}
