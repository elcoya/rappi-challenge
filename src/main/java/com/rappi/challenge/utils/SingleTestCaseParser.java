package com.rappi.challenge.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rappi.challenge.model.CubeOperation;
import com.rappi.challenge.model.CubeTestCase;
import com.rappi.challenge.utils.exceptions.InputFormatException;

@Component
public class SingleTestCaseParser {
	
	private static final String INVALID_TEST_CASE_HEADER = "Invalid Test Case header line. The format expected is two integers separated by a single space.";
	private static final String UNEXPECTED_END_OF_INPUT = "Unexpected end of input.";
	private static final Pattern PATTERN = Pattern.compile("^[0-9]+ [0-9]+$");

	@Autowired
	private SingleInstructionParser singleInstructionParser;
	
	public CubeTestCase parse(String[] lines, IntegerHolder firstLine, int maxLine) {
		int lineCounter = firstLine.getValue();
		
		if (lineCounter >= maxLine) {
			throw new InputFormatException(maxLine, UNEXPECTED_END_OF_INPUT);
		}
		Matcher matcher = PATTERN.matcher(lines[lineCounter]);
		if (!matcher.matches()) {
			throw new InputFormatException(lineCounter, INVALID_TEST_CASE_HEADER);
		}
		
		String[] strParameters = lines[lineCounter].split(" ");
		int cubeSize = Integer.parseInt(strParameters[0]);
		int instructionCount = Integer.parseInt(strParameters[1]);
		
		lineCounter++;
		if(lineCounter >= maxLine || (lineCounter + instructionCount) > maxLine) {
			throw new InputFormatException(maxLine, UNEXPECTED_END_OF_INPUT);
		}
		
		List<CubeOperation> operations = new ArrayList<>(instructionCount);
		for (int i = 0; i < instructionCount; i++) {
			CubeOperation operation = singleInstructionParser.parseInstruction(lines[lineCounter], lineCounter);
			operations.add(operation);
			lineCounter++;
		}
		
		firstLine.setValue(lineCounter);
		CubeTestCase target = new CubeTestCase();
		target.setCubeSize(cubeSize);
		target.setOperations(operations);
		return target;
	}

}
