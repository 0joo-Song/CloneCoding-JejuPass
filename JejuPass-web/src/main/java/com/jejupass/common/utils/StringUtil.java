package com.jejupass.common.utils;

import java.util.Random;

public class StringUtil {

    /**
     * 
     * Statements
     * 입력받은 길이만큼의 랜덤문자열 생성(숫자+대소문자 조합)
     * 
     * @param strLength 생성할 문자열 길이
     * @param uniType 대문자(U), 소문자(L), 대소문자 (T), 숫자만(N)
     * @return
     * @throws Exception
     */
    public static String getRandomString(int strLength, String uniType ) throws Exception {
        
        String strResult = "";

        char    ch     = 0;
        int     num    = 0;
        Random  rnd    = new Random();
        
        long rdSeed = System.currentTimeMillis(); 
        rnd.setSeed(rdSeed+rdSeed);
        
        for (int i = 1; i <= strLength; i++) {
        	
        	if(uniType.equals("N")) {         	// 숫자만 생성하는 로직 추가 (2014.10.15)
                num = rnd.nextInt(10);
                strResult += num;        		
        	} else {
	            int intFlag = rnd.nextInt(2);
	            int strFlag = rnd.nextInt(2);
	            
	            if(intFlag == 0) {
	                num = rnd.nextInt(10);
	                strResult += num;
	            } else {
	            	if(uniType.equals("L")) {	
	                    ch = (char) ((Math.random() * 26) + 97);    // 소문자
	            	} else if(uniType.equals("U")) {
	                    ch = (char) ((Math.random() * 26) + 65);    // 대문자    
	            	} else if(uniType.equals("T")) {
	                    if(strFlag == 0) {
	                        ch = (char) ((Math.random() * 26) + 65);    // 대문자    
	                    } else {
	                        ch = (char) ((Math.random() * 26) + 97);    // 소문자
	                    }            		
	            	}
	                strResult += ch;
	            }
        	}
        }
         
        return strResult;

    }
 
    /**
     * Statements
     * String 첫부분을 입력값 만큼 남기고 나머지 * 로 변경
     * ex) 1234567890 ==> (4) 입력 ==> 1234******
     * @param inputValue
     * @param method
     * @return
     */
    public static String replaceAsteriskFirst(String inputValue, int subNum) {
        
        String returnValue = "";
        
        if(inputValue == null || inputValue.equals("")) {
            return returnValue;
        }
        
        String add_asterisk = "";
        for(int i=0;i<inputValue.length()-subNum;i++) {
        	add_asterisk += "*";
        }
        
        if(inputValue.length() >= subNum+1) {
        	returnValue = inputValue.substring(0, subNum) + add_asterisk;
        }

        return returnValue;
    }
    
    
    /**
     * Statements
     * String 끝부분을 입력값 만큼 * 로 변경
     * ex) 1234567890 ==> (4)입력 ==> 123456****
     * @param inputValue
     * @param method
     * @return
     */
    public static String replaceAsteriskLast(String inputValue, int maskingNum) {
        
        String returnValue = "";
        
        if(inputValue == null || inputValue.equals("")) {
            return returnValue;
        }
        
        String add_asterisk = "";
        for(int i=0;i<maskingNum;i++) {
        	add_asterisk += "*";
        }
        
        if(inputValue.length() >= maskingNum) {
        	returnValue = inputValue.substring(0, inputValue.length() - maskingNum) + add_asterisk;
        }

        return returnValue;
    }    
    
    
    /**
     * 뮨자열 변경
     * @param original
     * @param older
     * @param newer
     * @return
     */
    public static String replace(String original, String older, String newer) {
        String result = original;

        if(original != null) {
            int idx = result.indexOf(older);
            int newLength = newer.length();

            while(idx >= 0) {
                if (idx == 0) {
                    result = newer + result.substring(older.length());
                }else {
                    result = result.substring(0, idx) + newer + result.substring(idx + older.length());
                }
                idx = result.indexOf(older, idx + newLength);
            }
        }
        return result;
    }
    
    /**
	 * String 내에 Html 태그 사용 특수문자를 변환
	 * @param str
	 * @return
	 */
    public static String stringToHtmlSign(String str) {
		return str.replaceAll("&amp;", "&")
				 .replaceAll("&lt;", "<")
				 .replaceAll("&gt;", ">")
		    	 .replaceAll("&#39;", "'")
		    	 .replaceAll("&quot;", "\"");
	}
}
