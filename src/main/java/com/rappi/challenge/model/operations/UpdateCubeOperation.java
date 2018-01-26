package com.rappi.challenge.model.operations;

import com.rappi.challenge.model.Cube;
import com.rappi.challenge.model.CubeOperation;

public class UpdateCubeOperation implements CubeOperation {

	private int x,y,z;
	private int value;

	public UpdateCubeOperation(int x, int y, int z, int value) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
	}
	
	@Override
	public void operate(Cube cube, StringBuilder output) {
		cube.updateCell(x, y, z, value);
	}

}
