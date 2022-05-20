package com.jejupass.web.customerSvc.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias("FaqEntity")
public class FaqEntity {
	/* 자주찾는질문 */
	
	private Integer faqSeq;
	private String faqType;
	private String title;
	private String contents;
	private String regDt;
	private String showYn;
}
