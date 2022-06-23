package com.jejupass.web.flight.dto.response;

import org.apache.ibatis.type.Alias;

import com.jejupass.web.flight.entity.FlightEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("FlightRespDto")
public class FlightRespDto {
	private FlightEntity result;
	private String test;
}
