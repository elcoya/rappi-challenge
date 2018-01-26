package com.rappi.challenge.model;

import com.rappi.challenge.model.exceptions.CoordinateOutOfBoundsException;
import com.rappi.challenge.model.exceptions.MalformedRangeException;
import com.rappi.challenge.model.exceptions.SizeTooHighException;
import com.rappi.challenge.model.exceptions.SizeTooLowException;

public class Cube {
	
	public static final int MAXIMUM_CUBE_DIMENSION = 100; //  1 <= N <= 100
	
	private int matrix[][][];
	private int size;

	public Cube(int size) {
		if (size < 1) {
			throw new SizeTooLowException();
		}
		if (size > MAXIMUM_CUBE_DIMENSION) {
			throw new SizeTooHighException();
		}
		this.size = size;
		this.matrix = new int[size][size][size]; // Is automatically initialized with zeros
	}
	
	public void validateCoordinates(int x, int y, int z) {
		if (x < 1 || x > this.size ||
				y < 1 || y > this.size ||
				z < 1 || z > this.size) {
			throw new CoordinateOutOfBoundsException();
		}
	}

	public void validateRange(int x1, int y1, int z1, int x2, int y2, int z2) {
		if (x1 > x2 || y1 > y2 || z1 > z2) {
			throw new MalformedRangeException();
		}
	}
	
	public int getCell(int x, int y, int z) {
		validateCoordinates(x, y, z);
		return this.matrix[x-1][y-1][z-1]; // Cube Coordinates starts @ 1
	}
	
	public void updateCell(int x, int y, int z, int value) {
		validateCoordinates(x, y, z);
		this.matrix[x-1][y-1][z-1] = value; // Cube Coordinates starts @ 1
	}
	
	public int sumRange(int x1, int y1, int z1, int x2, int y2, int z2) {
		validateCoordinates(x1, y1, z1);
		validateCoordinates(x2, y2, z2);
		validateRange(x1, y1, z1, x2, y2, z2);
		
		int sum = 0;
		for (int i = x1 - 1; i < x2; i++) {
			for (int j = y1 - 1; j < y2; j++) {
				for (int k = z1 - 1; k < z2; k++) {
					sum += this.matrix[i][j][k];
				}
			}
		}

		return sum;
	}
}
