//package com.ipbs.common.handler;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//@ControllerAdvice
//public class CommExceptionHandler {
//
//	Logger log = LoggerFactory.getLogger(CommExceptionHandler.class);
//
//	
//	@ExceptionHandler(Exception.class)
//    public String exceptiHandler(Exception ex, Model model) {
//		log.info(ex.toString());
//		return "redirect:/comm/error.do";
//    }
//	
//	@ExceptionHandler(NoHandlerFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//    public String noHandlerFoundException(NoHandlerFoundException ex) {
//		log.info("404 error 다르게 처리 필요");
//		return "redirect:/comm/error.do";
//    }	
//
//}
