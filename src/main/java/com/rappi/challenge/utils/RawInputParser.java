package com.rappi.challenge.utils;

import org.springframework.stereotype.Component;

import com.rappi.challenge.model.CubeTestCasesSet;

@Component
public class RawInputParser {

	public CubeTestCasesSet parseInput(String input) {
		return new CubeTestCasesSet();
	}
	
}
