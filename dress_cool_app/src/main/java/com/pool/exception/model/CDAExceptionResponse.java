/**
 * 
 */
package com.pool.exception.model;

import java.util.Date;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author dasar
 *
 */
public class CDAExceptionResponse {
	private Date timeStamp;
	private String errorMessage;
	private String exceptionDetails;
	private String path;

	public CDAExceptionResponse(Date timeStamp, String errorMessage, String exceptionDetails) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
		this.exceptionDetails = exceptionDetails;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getExceptionDetails() {
		return exceptionDetails;
	}

	public void setExceptionDetails(String exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}

}
