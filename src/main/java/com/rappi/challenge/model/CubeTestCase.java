package com.rappi.challenge.model;

import java.util.List;

public class CubeTestCase {

	private int cubeSize = 1;
	private List<CubeOperation> operations;
	
	public void setCubeSize(int cubeSize) {
		this.cubeSize = cubeSize;
	}
	
	public void setOperations(List<CubeOperation> operations) {
		this.operations = operations;
	}
	
	public String execute() {
		StringBuilder outputBuilder = new StringBuilder();
		Cube cube = new Cube(cubeSize);
		for (CubeOperation operation : operations) {
			operation.operate(cube , outputBuilder);
		}
		return outputBuilder.toString();
	}

}
