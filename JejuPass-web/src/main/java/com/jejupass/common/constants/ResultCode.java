package com.jejupass.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
	RESULT_SUCCESS("success"),
	RESULT_FAIL("fail");	
	
	String code;  
	
}