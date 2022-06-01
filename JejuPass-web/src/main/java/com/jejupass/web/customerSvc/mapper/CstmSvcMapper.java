package com.jejupass.web.customerSvc.mapper;

import java.util.List;

import com.jejupass.web.customerSvc.dto.request.NoticeReqDto;
import com.jejupass.web.customerSvc.entity.NoticeEntity;

public interface CstmSvcMapper {

	int selectNoticeListCnt(NoticeReqDto noticeReqDto);

	List<NoticeEntity> selectNoticeList(NoticeReqDto noticeReqDto);

}
