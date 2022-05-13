package com.jejupass.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
	SUCCESS("success"),
	FAIL("fail");	
	
	String code;  
	
}