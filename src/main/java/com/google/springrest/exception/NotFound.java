package com.google.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//by default exception is java feature and to show the proper exception at front end we need 
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException{
	public NotFound(String message) {
		super(message);
	}
	public NotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
