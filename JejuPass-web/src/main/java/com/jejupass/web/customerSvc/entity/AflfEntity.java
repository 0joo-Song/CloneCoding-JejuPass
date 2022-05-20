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
@Alias("AflfEntity")
public class AflfEntity {
	/* 가맹점/제휴 문의 */
	
	private Integer aflfSeq;
	private String mainCtgr;
	private String subCtgr;
	private String companyNm;
	private String managerNm;
	private String telNo;
	private String addr;
	private String contents;
	private String regDt;
}
