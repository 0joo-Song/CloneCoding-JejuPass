package com.jejupass.web.restaurant.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("RstrReqDto")
public class RstrReqDto {
	private String srchText;
	private String filterTag;
	private String filterArea;
	private String filterMenu;
	private String filterCvnc;
	
	private Integer RstrSeq;
}
