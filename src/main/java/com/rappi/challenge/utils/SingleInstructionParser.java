package com.rappi.challenge.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.rappi.challenge.model.CubeOperation;
import com.rappi.challenge.utils.exceptions.InputFormatException;

@Component
public class SingleInstructionParser {
	
	private static final String INVALID_FORMAT_DETAILS = "Invalid format. Please review your sintax.";
	private HashMap<String, OperationParsingStrategy> strategiesMap;
	private List<Pattern> validLinePatterns;

	public SingleInstructionParser() {
		this.strategiesMap = new HashMap<>();
		strategiesMap.put(CubeOperationType.QUERY.name(), new QueryOperationParsingStrategy());
		strategiesMap.put(CubeOperationType.UPDATE.name(), new UpdateOperationParsingStrategy());
		
		validLinePatterns = new ArrayList<>();
		validLinePatterns.add(CubeOperationType.QUERY.getValidPattern());
		validLinePatterns.add(CubeOperationType.UPDATE.getValidPattern());
	}

	public CubeOperation parseInstruction(String line, int lineCounter) {
		validateLine(line, lineCounter);
		String keyword = line.split(" ")[0];
		OperationParsingStrategy chosenStrategy = this.strategiesMap.get(keyword);
		return chosenStrategy.parse(line);
	}

	private void validateLine(String line, int lineCounter) {
		boolean valid = false;
		for (Pattern pattern : validLinePatterns) {
			if (pattern.matcher(line).matches()) {
				valid = true; 
			}
		}
		if (!valid) {
			throw new InputFormatException(lineCounter, INVALID_FORMAT_DETAILS);
		}
	}

}
