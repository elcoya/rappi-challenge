package com.rappi.challenge.utils;

import java.util.regex.Pattern;

public enum CubeOperationType {

	QUERY("^QUERY [0-9]+ [0-9]+ [0-9]+ [0-9]+ [0-9]+ [0-9]+$"),
	UPDATE("^UPDATE [0-9]+ [0-9]+ [0-9]+ [0-9]+$");

	private Pattern validPattern;
	private CubeOperationType(String validationPattern) {
		this.validPattern = Pattern.compile(validationPattern);
	}
	
	
	public Pattern getValidPattern() {
		return this.validPattern;
	}
	
}
