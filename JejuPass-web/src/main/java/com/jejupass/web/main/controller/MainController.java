package com.jejupass.web.main.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jejupass.web.comm.dto.request.CommCdReqDto;
import com.jejupass.web.main.service.MainService;

@Controller
public class MainController {
	
	Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Resource(name="mainService")
	private MainService mainService;
	
	/**
	 * 메인 - 메인 페이지 이동
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index.do", method = { RequestMethod.GET, RequestMethod.POST })
		public String mainIndex() throws Exception {
		return "web/index";
	}
	
	@RequestMapping(value = "/dataSave.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String dataSaveTest(Model model) throws Exception {
		CommCdReqDto testCd = new CommCdReqDto();
		testCd.setCommCd("test");
		testCd.setCdName("테스트");
		testCd.setCdDesc("저장 테스트");
		int check = mainService.test(testCd);
	return "redirect:/";
	}
}
