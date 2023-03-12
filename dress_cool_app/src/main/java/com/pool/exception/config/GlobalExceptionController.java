package com.pool.exception.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pool.exception.model.CDAExceptionResponse;
import com.pool.exception.model.DressNotFoundException;

@RestControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(value = {DressNotFoundException.class,Exception.class})
	public ResponseEntity<Object> internalExceptionHandler(HttpServletRequest request, Exception ex) {
		CDAExceptionResponse exceptionObject = new CDAExceptionResponse(new Date(), ex.getMessage(),
				"Context Path:" + request.getContextPath() + request.getRequestURI());
		return new ResponseEntity<Object>(exceptionObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
