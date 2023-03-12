package com.pool.servlet;

public class CustomnResponse {
	private String message;
	private String code;
	public String getMessage() {
		return message;
	}
	public CustomnResponse setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getCode() {
		return code;
	}
	public CustomnResponse setCode(String code) {
		this.code = code;
		return this;
	}
	
	
}
