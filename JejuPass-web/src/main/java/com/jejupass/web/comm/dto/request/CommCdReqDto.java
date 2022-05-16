package com.jejupass.web.comm.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("CommCdReqDto")
public class CommCdReqDto {
	private Integer commCdSeq;	// 일련번호
	private String commCd;		// 공통코드
	private String parentCd;	// 부모코드
	private String cdName;		// 공통코드명
	private String cdDesc;		// 설명
}
