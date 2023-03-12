package com.pool.model;

public class CommonResponseModel {
	private String message;
	private Integer statusCode;

	public CommonResponseModel() {

	}

	public String getMessage() {
		return message;
	}

	public CommonResponseModel setMessage(String message) {
		this.message = message;
		return this;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public CommonResponseModel setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}

}
