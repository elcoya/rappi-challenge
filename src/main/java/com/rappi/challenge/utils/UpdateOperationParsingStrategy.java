package com.rappi.challenge.utils;

import com.rappi.challenge.model.CubeOperation;
import com.rappi.challenge.model.operations.UpdateCubeOperation;

public class UpdateOperationParsingStrategy implements OperationParsingStrategy {

	@Override
	public CubeOperation parse(String line) {
		String[] splittedLine = line.split(" ");
		UpdateCubeOperation operation = new UpdateCubeOperation(
				Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]), Integer.parseInt(splittedLine[3]),
				Integer.parseInt(splittedLine[4]));
		return operation;
	}

}
