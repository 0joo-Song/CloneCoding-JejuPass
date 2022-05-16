package com.jejupass.web.customerSvc.dto.response;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("FaqRespDto")
public class FaqRespDto {
	private Integer faqSeq;
	private String faqType;
	private String title;
	private String contents;
	private String regDt;
	private String showYn;
}	
