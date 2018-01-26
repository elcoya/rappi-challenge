package com.rappi.challenge.utils;

import com.rappi.challenge.model.CubeOperation;
import com.rappi.challenge.model.operations.QueryCubeOperation;

public class QueryOperationParsingStrategy implements OperationParsingStrategy {

	@Override
	public CubeOperation parse(String line) {
		String[] splittedLine = line.split(" ");
		QueryCubeOperation operation = new QueryCubeOperation(
				Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]), Integer.parseInt(splittedLine[3]),
				Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), Integer.parseInt(splittedLine[6]));
		return operation;
	}

}
