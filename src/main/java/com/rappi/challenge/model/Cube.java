package com.rappi.challenge.model;

import com.rappi.challenge.model.exceptions.CoordinateOutOfBoundsException;
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

	private void validateCoordinates(int x, int y, int z) {
		if (x < 1 || x > this.size ||
			y < 1 || y > this.size ||
			z < 1 || z > this.size) {
			throw new CoordinateOutOfBoundsException();
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
	
}
