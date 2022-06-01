package com.jejupass.web.customerSvc.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("NoticeReqDto")
public class NoticeReqDto {
	private String srchType;
	private String srchText;
	
}
