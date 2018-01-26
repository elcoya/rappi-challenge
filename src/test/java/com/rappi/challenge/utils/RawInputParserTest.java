package com.rappi.challenge.utils;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rappi.challenge.model.CubeTestCase;

public class RawInputParserTest {

	@InjectMocks
	private RawInputParser target;
	
	@Mock
	private SingleTestCaseParser singleTestCaseParser;
	
	private CubeTestCase aTestCase = new CubeTestCase();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(singleTestCaseParser.parse(any(), any(IntegerHolder.class), anyInt())).thenReturn(aTestCase);
	}

	@Test
	public void testParseInput() {
		String eol = System.lineSeparator();
		String input = String.format("1%sAnother line%sLast line%s", eol, eol, eol);
		target.parseInput(input);
		
		Mockito.verify(singleTestCaseParser).parse(any(), any(IntegerHolder.class), anyInt());
	}

}
