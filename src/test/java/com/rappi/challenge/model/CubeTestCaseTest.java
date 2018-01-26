package com.rappi.challenge.model;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CubeTestCaseTest {

	@InjectMocks
	private CubeTestCase target;
	
	private List<CubeOperation> operations;
	@Mock
	private CubeOperation op1;
	@Mock
	private CubeOperation op2;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		operations = Arrays.asList(op1, op2);
		this.target.setOperations(operations);
	}

	@Test
	public void testExecute() {
		
		target.execute();
		
		Mockito.verify(op1).operate(Matchers.any(Cube.class), Matchers.any(StringBuilder.class));
		Mockito.verify(op2).operate(Matchers.any(Cube.class), Matchers.any(StringBuilder.class));
		
	}

}
