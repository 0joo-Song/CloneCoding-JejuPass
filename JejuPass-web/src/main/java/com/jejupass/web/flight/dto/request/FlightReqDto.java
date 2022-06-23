package com.jejupass.web.flight.dto.request;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("FlightReqDto")
public class FlightReqDto {	
	private String schDate;
	private String schDeptCityCode;
	private String schArrvCityCode;
	private String schAirLine;
	private String schFlightNum;

}
