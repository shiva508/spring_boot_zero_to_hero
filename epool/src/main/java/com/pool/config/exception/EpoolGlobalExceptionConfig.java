package com.pool.config.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pool.model.exception.CustomErrorResponse;
import com.pool.model.exception.NoRecardsFoundException;

@RestControllerAdvice
public class EpoolGlobalExceptionConfig {
	@ExceptionHandler(value = NoRecardsFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(NoRecardsFoundException error) {
		
		return commonExceptionGenerator(
				HttpStatus.NOT_FOUND.toString(), 
				error.getMessage(), 
				HttpStatus.NOT_FOUND.value(), 
				new Date(), 
				HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<CustomErrorResponse> commonExceptionGenerator(String errorCode, String errorMsg,
			Integer status, Date timestamp, HttpStatus httpStatus) {
		return new ResponseEntity<CustomErrorResponse>(
				new CustomErrorResponse()
				.setErrorCode(errorCode)
				.setErrorMsg(errorMsg)
				.setStatus(status)
				.setTimestamp(timestamp), 
				 httpStatus);
	}
}
