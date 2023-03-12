/**
 * 
 */
package com.pool.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dasar
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DressNotFoundException extends RuntimeException {

	public DressNotFoundException(String message) {
		super(message);
	}

}
