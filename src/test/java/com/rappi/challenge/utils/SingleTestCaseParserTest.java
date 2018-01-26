package com.rappi.challenge.utils;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rappi.challenge.model.CubeOperation;
import com.rappi.challenge.model.CubeTestCase;

public class SingleTestCaseParserTest {

	@InjectMocks
	private SingleTestCaseParser target;
	
	@Mock
	private SingleInstructionParser singleInstructionParser;

	@Mock
	private CubeOperation mockOperation;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(singleInstructionParser.parseInstruction(anyString(), anyInt())).thenReturn(mockOperation);
	}
	
	@Test
	public void testParseQuery() {
		String eol = System.lineSeparator();
		
		String input = "1" + eol +
				"1 1" + eol +
				"QUERY 1 1 1 1 1 1";
		
		String[] lines = input .split(eol);
		IntegerHolder lineCounter = new IntegerHolder(1);
		CubeTestCase actual = target.parse(lines , lineCounter, lines.length);
		
		Assert.assertEquals(3, lineCounter.getValue());
		Mockito.verify(singleInstructionParser).parseInstruction(lines[2], 2);
		
		CubeTestCase expected = new CubeTestCase();
		expected.setCubeSize(1);
		expected.setOperations(Arrays.asList(mockOperation));
		
		assertReflectionEquals(expected, actual);
	}

	@Test
	public void testParseUpdate() {
		String eol = System.lineSeparator();
		
		String input = "1" + eol +
				"1 1" + eol +
				"UPDATE 1 1 1 4";
		
		String[] lines = input .split(eol);
		IntegerHolder lineCounter = new IntegerHolder(1);
		CubeTestCase actual = target.parse(lines , lineCounter, lines.length);
		
		Assert.assertEquals(3, lineCounter.getValue());
		Mockito.verify(singleInstructionParser).parseInstruction(lines[2], 2);
		
		CubeTestCase expected = new CubeTestCase();
		expected.setCubeSize(1);
		expected.setOperations(Arrays.asList(mockOperation));
		
		assertReflectionEquals(expected, actual);
	}

}
