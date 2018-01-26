package com.rappi.challenge.utils;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rappi.challenge.model.CubeOperation;
import com.rappi.challenge.model.CubeTestCase;
import com.rappi.challenge.model.CubeTestCasesSet;
import com.rappi.challenge.model.operations.QueryCubeOperation;
import com.rappi.challenge.model.operations.UpdateCubeOperation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RawInputParserIntegrationTest {

	@Autowired
	private RawInputParser target;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testParseMinimalInput() {
		String rawInput = String.format("%d%s%d %d%s%s%s", 
				1, System.lineSeparator(),
				4, 1, System.lineSeparator(),
				"QUERY 1 1 1 4 4 4", System.lineSeparator());
		
		CubeTestCasesSet actual = target.parseInput(rawInput);
		
		List<CubeOperation> operations = new ArrayList<>();
		operations.add(new QueryCubeOperation(1, 1, 1, 4, 4, 4));
		
		CubeTestCase testCase = new CubeTestCase();
		testCase.setCubeSize(4);
		testCase.setOperations(operations);
		
		CubeTestCasesSet expected = new CubeTestCasesSet();
		expected.addTestCase(testCase);
		
		assertReflectionEquals(expected, actual);
	}
	
	@Test
	public void testParseInput() {
		String rawInput = String.format("%d%s%d %d%s%s%s%s%s", 
				1, System.lineSeparator(),
				4, 2, System.lineSeparator(),
				"UPDATE 2 2 2 4", System.lineSeparator(),
				"QUERY 1 1 1 4 4 4", System.lineSeparator());
		
		CubeTestCasesSet actual = target.parseInput(rawInput);
		
		List<CubeOperation> operations = new ArrayList<>();
		operations.add(new UpdateCubeOperation(2, 2, 2, 4));
		operations.add(new QueryCubeOperation(1, 1, 1, 4, 4, 4));
		
		CubeTestCase testCase = new CubeTestCase();
		testCase.setCubeSize(4);
		testCase.setOperations(operations);
		
		CubeTestCasesSet expected = new CubeTestCasesSet();
		expected.addTestCase(testCase);
		
		assertReflectionEquals(expected, actual);
	}

	@Test
	public void testParseInputMultipleCases() {
		
		String header = String.format("%d%s", 3, System.lineSeparator());
		String firstTestCase = String.format("%d %d%s%s%s%s%s", 
				4, 2, System.lineSeparator(),
				"UPDATE 2 2 2 4", System.lineSeparator(),
				"QUERY 1 1 1 4 4 4", System.lineSeparator());
		String secondTestCase = String.format("%d %d%s%s%s%s%s%s%s", 
				3, 3, System.lineSeparator(),
				"UPDATE 1 2 3 1", System.lineSeparator(),
				"UPDATE 3 1 2 4", System.lineSeparator(),
				"QUERY 1 1 1 3 3 3", System.lineSeparator());
		String thirdTestCase = String.format("%d %d%s%s%s%s%s%s%s%s%s%s%s", 
				10, 5, System.lineSeparator(),
				"UPDATE 1 2 3 1", System.lineSeparator(),
				"UPDATE 3 1 2 4", System.lineSeparator(),
				"QUERY 1 2 3 3 3 3", System.lineSeparator(),
				"UPDATE 1 1 1 4", System.lineSeparator(),
				"QUERY 1 1 1 3 3 3", System.lineSeparator());
		String rawInput = String.format("%s%s%s%s", header, firstTestCase, secondTestCase, thirdTestCase);
		
		CubeTestCasesSet actual = target.parseInput(rawInput);
		
		// Building expected
		List<CubeOperation> operations1 = new ArrayList<>();
		operations1.add(new UpdateCubeOperation(2, 2, 2, 4));
		operations1.add(new QueryCubeOperation(1, 1, 1, 4, 4, 4));
		
		CubeTestCase testCase1 = new CubeTestCase();
		testCase1.setCubeSize(4);
		testCase1.setOperations(operations1);
		
		List<CubeOperation> operations2 = new ArrayList<>();
		operations2.add(new UpdateCubeOperation(1, 2, 3, 1));
		operations2.add(new UpdateCubeOperation(3, 1, 2, 4));
		operations2.add(new QueryCubeOperation(1, 1, 1, 3, 3, 3));
		
		CubeTestCase testCase2 = new CubeTestCase();
		testCase2.setCubeSize(3);
		testCase2.setOperations(operations2);
		
		
		List<CubeOperation> operations3 = new ArrayList<>();
		operations3.add(new UpdateCubeOperation(1, 2, 3, 1));
		operations3.add(new UpdateCubeOperation(3, 1, 2, 4));
		operations3.add(new QueryCubeOperation(1, 2, 3, 3, 3, 3));
		operations3.add(new UpdateCubeOperation(1, 1, 1, 4));
		operations3.add(new QueryCubeOperation(1, 1, 1, 3, 3, 3));
		
		CubeTestCase testCase3 = new CubeTestCase();
		testCase3.setCubeSize(10);
		testCase3.setOperations(operations3);
		
		
		CubeTestCasesSet expected = new CubeTestCasesSet();
		expected.addTestCase(testCase1);
		expected.addTestCase(testCase2);
		expected.addTestCase(testCase3);
		
		assertReflectionEquals(expected, actual);
	}

}
