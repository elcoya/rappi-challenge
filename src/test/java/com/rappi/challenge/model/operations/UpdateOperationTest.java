package com.rappi.challenge.model.operations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rappi.challenge.model.Cube;

public class UpdateOperationTest {

	private static final int TEST_VALUE = 10;
	
	@Mock
	private Cube cube;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testOperate() {
		UpdateCubeOperation target = new UpdateCubeOperation(1, 1, 1, TEST_VALUE);
		StringBuilder output = new StringBuilder();
		
		target.operate(cube, output);
		
		Mockito.verify(cube).updateCell(1, 1, 1, TEST_VALUE);
		Assert.assertEquals("", output.toString());
	}

}
