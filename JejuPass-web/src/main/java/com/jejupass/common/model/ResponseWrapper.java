package com.jejupass.common.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseWrapper {
	
	public static ResponseEntity createRespEntity(HttpStatus httpStatus) {
		return new ResponseEntity<>(httpStatus);
	}
	
	public static ResponseEntity createSuccessEntity() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public static ResponseEntity createSuccessEntity(HttpStatus httpStatus) {
		return new ResponseEntity<>(httpStatus);
	}
	
	public static <T> ResponseEntity<T> createSuccessEntity(T body) {
		return createSuccessEntity(body, HttpStatus.OK);
	}
	
	public static <T> ResponseEntity<T> createSuccessEntity(T body, HttpStatus httpStatus) {
		return new ResponseEntity<>(body, httpStatus);
	}
	
	public static <T> ResponseEntity<T> createFailEntity() {
		return createFailEntity(" ", " ", HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
	public static <T> ResponseEntity<T> createFailEntity(String errorCode) {
		return createFailEntity(errorCode, " ", HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
	public static <T> ResponseEntity<T> createFailEntity(String errorCode, String errorMsg) {
		return createFailEntity(errorCode, errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
	public static <T> ResponseEntity<T> createFailEntity(String errorCode, String errorMsg, HttpStatus httpStatus) {
		
		ErrorModel error = new ErrorModel();
		error.setCode(errorCode);
		error.setMessage(errorMsg);
		
		ResponseModel res = new ResponseModel();
		res.setError(error);
 
		return new ResponseEntity(res, httpStatus);
	}
	
}