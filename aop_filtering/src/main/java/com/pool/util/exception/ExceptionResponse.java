package com.pool.util.exception;

import java.util.Date;

public class ExceptionResponse{
	private Date date;
	private String message;
	private String details;

	public ExceptionResponse(Date date2, String message, String details) {
		super();
		this.date = date2;
		this.message = message;
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [date=" + date + ", message=" + message + ", details=" + details + "]";
	}

}
