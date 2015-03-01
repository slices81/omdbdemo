package com.alexdunlop.omdb;

import org.springframework.validation.Errors;

public class InvalidRequestException extends RuntimeException {

	private Errors errors;

	public InvalidRequestException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidRequestException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}
}
	
