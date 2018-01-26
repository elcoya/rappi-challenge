package com.rappi.challenge.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rappi.challenge.model.exceptions.CoordinateOutOfBoundsException;
import com.rappi.challenge.model.exceptions.SizeTooHighException;
import com.rappi.challenge.model.exceptions.SizeTooLowException;

public class CubeTest {

	private static final int DEFAULT_CUBE_SIZE = 10;
	private static final int EXCEDING_CUBE_SIZE = Cube.MAXIMUM_CUBE_DIMENSION * 2;
	private static final int DEFICIENT_CUBE_SIZE = 0;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCubeCreation() {
		Cube cube = new Cube(DEFAULT_CUBE_SIZE);
		for (int i = 0; i < DEFAULT_CUBE_SIZE; i++) {
			for (int j = 0; j < DEFAULT_CUBE_SIZE; j++) {
				for (int k = 0; k < DEFAULT_CUBE_SIZE; k++) {
					Assert.assertEquals(0, cube.getCell(i+1, j+1, k+1));
				}
			}
		}
	}
	
	@Test(expected = SizeTooHighException.class)
	public void testCubeCreationTooHighSizeError() {
		new Cube(EXCEDING_CUBE_SIZE);
	}

	@Test(expected = SizeTooLowException.class)
	public void testCubeCreationTooLowSizeError() {
		new Cube(DEFICIENT_CUBE_SIZE);
	}
	
	@Test
	public void testCubeInitialization() {
		int sizes[] = new int[] {1, Cube.MAXIMUM_CUBE_DIMENSION/2, Cube.MAXIMUM_CUBE_DIMENSION};
		for (int l = 0; l < sizes.length; l++) {
			int size = sizes[l];
			Cube cube = new Cube(size);
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					for (int k = 0; k < size; k++) {
						Assert.assertEquals(0, cube.getCell(i+1, j+1, k+1));
					}
				}
			}
		}
	}
	
	@Test
	public void testCubeUpdate() {
		Cube cube = new Cube(DEFAULT_CUBE_SIZE);
		for (int i = 0; i < DEFAULT_CUBE_SIZE; i++) {
			for (int j = 0; j < DEFAULT_CUBE_SIZE; j++) {
				for (int k = 0; k < DEFAULT_CUBE_SIZE; k++) {
					cube.updateCell(i+1, j+1, k+1, 1);
					Assert.assertEquals(1, cube.getCell(i+1, j+1, k+1));
				}
			}
		}
	}

	
	@Test(expected = CoordinateOutOfBoundsException.class)
	public void testXCoordinateOverflow() {
		Cube cube = new Cube(DEFAULT_CUBE_SIZE);
		cube.getCell(DEFAULT_CUBE_SIZE + 1, 1, 1);
	}
	
	@Test(expected = CoordinateOutOfBoundsException.class)
	public void testXCoordinateUnderflow() {
		Cube cube = new Cube(DEFAULT_CUBE_SIZE);
		cube.getCell(-1, 1, 1);
	}
	
	@Test(expected = CoordinateOutOfBoundsException.class)
	public void testYCoordinateOverflow() {
		Cube cube = new Cube(DEFAULT_CUBE_SIZE);
		cube.getCell(1, DEFAULT_CUBE_SIZE + 1, 1);
	}
	
	@Test(expected = CoordinateOutOfBoundsException.class)
	public void testYCoordinateUnderflow() {
		Cube cube = new Cube(DEFAULT_CUBE_SIZE);
		cube.getCell(1, -1, 1);
	}
	
	@Test(expected = CoordinateOutOfBoundsException.class)
	public void testZCoordinateOverflow() {
		Cube cube = new Cube(DEFAULT_CUBE_SIZE);
		cube.getCell(1, 1, DEFAULT_CUBE_SIZE + 1);
	}

	@Test(expected = CoordinateOutOfBoundsException.class)
	public void testZCoordinateUnderflow() {
		Cube cube = new Cube(DEFAULT_CUBE_SIZE);
		cube.getCell(1, 1, -1);
	}
	
}
