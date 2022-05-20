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
@Alias("NoticeEntity")
public class NoticeEntity {
	/* 공지사항 */
	
	private Integer noticeSeq;
	private String noticeType;
	private String title;
	private String contents;
	private String regDt;
	private String showYn;
	private Integer atchFileSeq;
}
