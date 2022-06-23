package com.jejupass.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FlightCode {
	GMP("GMP","서울/김포"),
	PUS("PUS","부산"),
	CJU("CJU","제주"),
	TAE("TAE","대구"),
	USN("USN","울산"),
	CJJ("CJJ","청주"),
	MWX("MWX","무안"),
	KWJ("KWJ","광주"),
	RSU("RSU","여수"),
	KPO("KPO","포항"),
	YNY("YNY","양양"),
	HIN("HIN","사천"),
	KUV("KUV","군포"),
	WJU("WJU","횡성/원주");
	
	private String code;
	private String name;  
	
}
