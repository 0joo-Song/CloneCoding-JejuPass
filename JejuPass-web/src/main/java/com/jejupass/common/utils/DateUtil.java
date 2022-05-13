package com.jejupass.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	/**
	 * 패턴에 맞춰서 현재 시간 리턴
	 * @param pattern  (yyyy/MM/dd HH:mm:ss)
	 * @return
	 * @throws Exception
	 */
    public static String getCurrDateByPattern(String pattern) {
    	
    	LocalDateTime now = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    	String fmtCurrDate = now.format(formatter);
    	System.out.println(fmtCurrDate); // 2021/06/17

    	return fmtCurrDate;
    }
}
