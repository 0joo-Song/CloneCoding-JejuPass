package com.jejupass.web.customerSvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CstmSvcContoller {
	
	Logger log = LoggerFactory.getLogger(CstmSvcContoller.class);
	
	/*   공지사항   */
	
	
	/*   자주 찾는 질문   */
	
	
	/*   가맹점/제휴 신청   */
	
	
	/*   회원혜택 안내   */
	@RequestMapping(value="/cstmSvc/userBenefit.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String userBenefit() throws Exception {
		log.info("/ userBenefit /");
        return "web/customerSvc/userBenefit";
    }
}	
