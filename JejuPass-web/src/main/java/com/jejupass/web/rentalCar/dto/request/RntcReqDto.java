package com.jejupass.web.rentalCar.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("RntcReqDto")
public class RntcReqDto {
	private Integer rntcSeq;
	private String startDt;
	private String endDt;
	private String startTime;
	private String endTime;
}	