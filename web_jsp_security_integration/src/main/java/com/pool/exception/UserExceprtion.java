package com.pool.exception;


public class UserExceprtion  {
	String exception;
	public UserExceprtion() {
		
	}
	public UserExceprtion(String exception) {
		super();
		this.exception = exception;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	@Override
	public String toString() {
		return "UserExceprtion [exception=" + exception + "]";
	}
	
	
}
