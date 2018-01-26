package com.rappi.challenge.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rappi.challenge.model.CubeTestCasesSet;
import com.rappi.challenge.utils.RawInputParser;

public class CubeSummationServiceTest {

	@InjectMocks
	private CubeSummationService target;
	
	@Mock
	private RawInputParser rawInputParser;
	
	@Mock
	private CubeTestCasesSet cubeTestCasesSet;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(rawInputParser.parseInput(Mockito.anyString())).thenReturn(cubeTestCasesSet);
	}

	@Test
	public void testSolveInput() {
		
		target.solveInput("Some input");
		
		Mockito.verify(cubeTestCasesSet).execute();
	}

}
