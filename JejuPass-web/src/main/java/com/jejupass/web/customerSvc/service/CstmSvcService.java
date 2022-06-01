package com.jejupass.web.customerSvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jejupass.web.customerSvc.dto.request.NoticeReqDto;
import com.jejupass.web.customerSvc.dto.response.NoticeRespDto;
import com.jejupass.web.customerSvc.entity.NoticeEntity;
import com.jejupass.web.customerSvc.mapper.CstmSvcMapper;

@Service
public class CstmSvcService {
	
	@Autowired
	private CstmSvcMapper cstmSvcMapper;
	
	public NoticeRespDto selectNoticeList(NoticeReqDto noticeReqDto) {
		
		// notice list Count 조회
		int totalCnt = cstmSvcMapper.selectNoticeListCnt(noticeReqDto); 
		// notice list 조회
		List<NoticeEntity> noticeList = cstmSvcMapper.selectNoticeList(noticeReqDto);
		
		NoticeRespDto resp = new NoticeRespDto();
		return resp;
	}

}
