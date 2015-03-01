package com.alexdunlop.omdb.exceptions;

public class MovieSearchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5396436047953767799L;

	public MovieSearchException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MovieSearchException(String message) {
		super(message);
		
	}

}
