package com.jejupass.web.comm.dto.response;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("CommCdRespDto")
public class CommCdRespDto {
	private Integer commCdSeq;	// 일련번호
	private String commCd;		// 공통코드
	private String parentCd;	// 부모코드
	private String cdName;		// 공통코드명
	private String cdDesc;		// 설명
}
