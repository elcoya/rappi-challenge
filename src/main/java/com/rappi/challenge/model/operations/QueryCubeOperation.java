package com.rappi.challenge.model.operations;

import com.rappi.challenge.model.Cube;
import com.rappi.challenge.model.CubeOperation;

public class QueryCubeOperation implements CubeOperation {
	
	private int x1,y1,z1;
	private int x2,y2,z2;
	
	public QueryCubeOperation(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
	}

	@Override
	public void operate(Cube cube, StringBuilder output) {
		output.append(String.format("%d%s", cube.sumRange(x1, y1, z1, x2, y2, z2), System.lineSeparator()));
	}

}
