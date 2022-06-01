package com.jejupass.web.customerSvc.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jejupass.web.customerSvc.dto.request.NoticeReqDto;
import com.jejupass.web.customerSvc.service.CstmSvcService;

@Controller
public class CstmSvcContoller {
	
	Logger log = LoggerFactory.getLogger(CstmSvcContoller.class);
	
	@Resource(name="cstmSvcService")
	private CstmSvcService cstmSvcService;	
	
	/*   공지사항   */
	@RequestMapping(value="/cstmSvc/notice.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String notice(Model model, NoticeReqDto noticeReqDto ) throws Exception {
		log.info("============ NOTICE ============");
		model.addAttribute("data", cstmSvcService.selectNoticeList(noticeReqDto));
        return "web/customerSvc/notice";
    }
	
	/*   자주 찾는 질문   */
	@RequestMapping(value="/cstmSvc/faq.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String faq() throws Exception {
		log.info("============ FAQ ============");
        return "web/customerSvc/faq";
    }
	
	/*   가맹점/제휴 신청   */
	@RequestMapping(value="/cstmSvc/affiliate.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String affiliate() throws Exception {
		log.info("============ AFFILIATE ============");
        return "web/customerSvc/affiliate";
    }
	
	/*   회원혜택 안내   */
	@RequestMapping(value="/cstmSvc/userBenefit.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String userBenefit() throws Exception {
		log.info("============ USER BENEFIT ============");
        return "web/customerSvc/userBenefit";
    }
}	
