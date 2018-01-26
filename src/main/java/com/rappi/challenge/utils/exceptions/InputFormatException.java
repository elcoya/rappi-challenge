package com.rappi.challenge.utils.exceptions;

public class InputFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int line;
	private String details;
	
	public InputFormatException(int line, String details) {
		this.line = line;
		this.details = details;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getLine() {
		return line;
	}

	public String getDetails() {
		return details;
	}
	
}
