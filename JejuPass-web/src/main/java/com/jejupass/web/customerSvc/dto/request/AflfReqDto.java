package com.jejupass.web.customerSvc.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("AflfReqDto")
public class AflfReqDto {
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
