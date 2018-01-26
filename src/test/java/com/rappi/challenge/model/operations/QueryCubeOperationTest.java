package com.rappi.challenge.model.operations;

import static org.mockito.Matchers.anyInt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rappi.challenge.model.Cube;

public class QueryCubeOperationTest {

	private static final int TEST_VALUE = 11;

	@Mock
	private Cube cube;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(cube.sumRange(anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(TEST_VALUE);
	}

	@Test
	public void testOperate() {
		QueryCubeOperation target = new QueryCubeOperation(1, 1, 1, 1, 1, 1);
		StringBuilder output = new StringBuilder();
		
		target.operate(cube, output);
		
		Mockito.verify(cube).sumRange(1, 1, 1, 1, 1, 1);
		Assert.assertEquals("" + TEST_VALUE + System.lineSeparator(), output.toString());
	}

}
