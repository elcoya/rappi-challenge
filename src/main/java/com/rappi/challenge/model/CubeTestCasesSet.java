package com.rappi.challenge.model;

import java.util.ArrayList;
import java.util.List;

public class CubeTestCasesSet {
	
	private List<CubeTestCase> testCases = new ArrayList<>();
	
	public void addTestCase(CubeTestCase testCase) {
		this.testCases.add(testCase);
	}

	public String execute() {
		StringBuilder outputBuilder = new StringBuilder();
		testCases.stream().map(testCase -> testCase.execute()).forEach(s -> outputBuilder.append(s));
		return outputBuilder.toString();
	}
}
