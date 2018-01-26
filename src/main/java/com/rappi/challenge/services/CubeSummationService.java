package com.rappi.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rappi.challenge.model.CubeTestCasesSet;
import com.rappi.challenge.utils.RawInputParser;
import com.rappi.challenge.utils.exceptions.InputFormatException;

@Service
public class CubeSummationService {

	@Autowired
	private RawInputParser inputParser;
	
	public String solveInput(String input) {
		try {
			CubeTestCasesSet testCasesSet = inputParser.parseInput(input);
			return testCasesSet.execute();
		} catch (InputFormatException e) {
			return e.getMessage();
		}
	}
	
}
