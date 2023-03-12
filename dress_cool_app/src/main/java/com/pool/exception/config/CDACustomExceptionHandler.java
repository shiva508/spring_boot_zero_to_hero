/**
 * 
 */
package com.pool.exception.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pool.exception.model.CDAExceptionResponse;
import com.pool.exception.model.DressNotFoundException;

/**
 * @author dasar
 *
 */

@RestControllerAdvice
public class CDACustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DressNotFoundException.class)
	public  ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		CDAExceptionResponse exceptionObject = new CDAExceptionResponse(new Date(), ex.getMessage(),
				"Context Path:"+request.getContextPath());
		return new ResponseEntity<Object>(exceptionObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
