package com.rappi.challenge.utils;

import com.rappi.challenge.model.CubeOperation;

public interface OperationParsingStrategy {

	CubeOperation parse(String line);
	
}
