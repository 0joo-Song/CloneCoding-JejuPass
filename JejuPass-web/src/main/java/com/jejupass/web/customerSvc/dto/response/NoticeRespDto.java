package com.jejupass.web.customerSvc.dto.response;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("NoticeRespDto")
public class NoticeRespDto {
	private Integer noticeSeq;
	private String noticeType;
	private String title;
	private String contents;
	private String regDt;
	private String showYn;
	private Integer atchFileSeq;
}
