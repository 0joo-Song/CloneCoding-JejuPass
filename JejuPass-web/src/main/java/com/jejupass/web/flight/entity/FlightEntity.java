package com.jejupass.web.flight.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias("FlightEntity")
public class FlightEntity {
	private String airlinehomepageUrl;
	private String airlineKorean;
	private String arrivalcity;
	private String domesticArrivalTime;
	private String domesticNum;
	private String domesticStartTime;
	private String startcity;
	private String domesticSun;
	private String domesticMon;
	private String domesticTue;
	private String domesticWed;
	private String domesticThu;
	private String domesticFri;
	private String domesticSat;
	private String numOfRows;
	private String pageNo;
	private String totalCount;
	
	
}
