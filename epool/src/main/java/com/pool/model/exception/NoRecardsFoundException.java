package com.pool.model.exception;

public class NoRecardsFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoRecardsFoundException(String message) {
		super(message);
	}

}
