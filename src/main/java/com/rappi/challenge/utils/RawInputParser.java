package com.rappi.challenge.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rappi.challenge.model.CubeTestCase;
import com.rappi.challenge.model.CubeTestCasesSet;
import com.rappi.challenge.utils.exceptions.InputFormatException;

@Component
public class RawInputParser {

	@Autowired
	private SingleTestCaseParser singleTestCaseParser;
	
	public CubeTestCasesSet parseInput(String input) {
		CubeTestCasesSet cubeTestCasesSet = new CubeTestCasesSet();
		
		String lines[] = input.split(System.lineSeparator());
		
		int testCaseCount = 0;
		try {
			testCaseCount = Integer.parseInt(lines[0]);
		} catch (NumberFormatException e) {
			throw new InputFormatException(0, "First line should be a single integer representing the amount of test cases that will follow");
		}
		IntegerHolder lineCounter = new IntegerHolder(1);
		int q = lines.length;
		for (int j = 0; j < testCaseCount; j++) {
			CubeTestCase aTestCase = singleTestCaseParser.parse(lines, lineCounter, q);
			cubeTestCasesSet.addTestCase(aTestCase);
		}
		
		return cubeTestCasesSet;
	}
	
}
