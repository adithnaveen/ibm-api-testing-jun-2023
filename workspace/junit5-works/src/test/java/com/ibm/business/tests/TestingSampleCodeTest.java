package com.ibm.business.tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import com.ibm.business.ITestingSampleCode;
import com.ibm.business.NameInvalidException;
import com.ibm.business.TestingSampleCode;

@TestMethodOrder(OrderAnnotation.class)
class TestingSampleCodeTest {

	/**
	 * @see BeforeAll & After all is generally used for DB Connection
	 */
	@BeforeAll
	static void initialize() {
		System.out.println("Your Initialization goes here ");
	}

	@AfterAll
	static void tearDownLast() {
		System.out.println("I'm the last one to go ");
	}

	// Variable section
	ITestingSampleCode tsc;
	private String validCaseName = null;
	private String invalidCaseName = "Amy";

	/**
	 * @see to initiatlize the variable
	 */
	@BeforeEach
	void setUp() {
		tsc = new TestingSampleCode();
		validCaseName = "Prashanth";
	}

	@AfterEach
	void tearDown() {
		System.out.println("Hi I'm afterEach");
	}

	@Order(1)
	@Test
	public void sampleTest() {
		assertEquals(true, true);
	}

	@Order(2)
	@Test
	@DisplayName("To test the name with valid case and say hello")
	public void sayHelloToTheNameSentValidCase() {
		String name = "Aswini";
		assertEquals("Hello " + name, tsc.sayHello(name));
	}

	@Order(3)
	@Test
	@DisplayName("To check if the name passed is more than 4 chars valid case ")
	public void checkNamePassedMoreThanFourChars() {
		assertTrue(tsc.checkName(validCaseName));
	}

	@Order(4)
	@Test
	@DisplayName("To check if the name passed is less than 4 chars valid case ")
	public void checkNamePassedLessThanFourChars() {
		// have to checkAgainst exception

		NameInvalidException nameInvalidException = assertThrows(NameInvalidException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				tsc.checkName(invalidCaseName);
			}
		}, "Sorry the name passed is not valid");

		assertEquals("Name Not Valid " + invalidCaseName, nameInvalidException.getMessage());
	}

	@Order(5)
	@Test
	@DisplayName("To check if the name passed is less than 4 chars valid case-Lambda ")
	public void checkNamePassedLessThanFourCharsWithLambda() {
		// have to checkAgainst exception

		NameInvalidException nameInvalidException = assertThrows(NameInvalidException.class,
				() -> tsc.checkName(invalidCaseName), "Sorry the name passed is not valid");

		assertEquals("Name Not Valid " + invalidCaseName, nameInvalidException.getMessage());
	}
	@Order(6)
	@Test
	@DisplayName("To check if there are names in the DB- valid case")
	public void toCheckNumberOfNamesMoreThanZero() {
		assertTrue(tsc.getNames().size() > 0, "No Names");
	}
	@Order(7)
	@Test
	@DisplayName("To check if there are 4 names in the DB - valid case")
	public void toCheckNumberOfNamesAre3() {
		assertEquals(4, tsc.getNames().size());
	}

	@Test
	@DisplayName("To check the name to be available before 1 second - valid case ")
	@Timeout(unit = TimeUnit.SECONDS, value = 3)
	public void toCheckNamesAvailableBefore1Sec() {
		assertEquals(4, tsc.getNames().size());
	}

	// grouped cases

	@Disabled
	@Test
	void groupedGetNames() {
		assertAll("GetNames cass", () -> {
			assertTrue(tsc.getNames().size() > 0, "No Names found in the database");
		}, () -> {
			assertEquals(3, tsc.getNames().size(), "Number of Names are not 4");
		}, () -> {
			Integer nameSize = assertTimeout(Duration.ofMillis(3000), () -> {
				return tsc.getNames().size();
			});

			assertEquals(4, nameSize);

		});
	}

	
	// parameterization 
	@ParameterizedTest
	@ValueSource(strings = {"Swetha", "Sanmeet", "Ishita", "Bhawesh", "AliAsger"})
	void checkForMultipleNamesValidCase(String name) {
		assertTrue(tsc.checkName(name), "Invalid case for " + name);
	}
	
	
	// similar to parameterization - Method Source 
	
	static Stream<String> getNamesToCheck() {
		return Stream.of("Lingaraj", "Hiranmai", "Aswini", "Zakhir");
	}
	
	@ParameterizedTest
	@MethodSource("getNamesToCheck")
	void checkForMultipleNamesValidCaseStreamOfValues(String name) {
		assertTrue(tsc.checkName(name), "Invalid case for " + name);
	}
	
	
	// assignment - TODO 
	// 1. create a csv file 
	// 2. in the CSV file have the names 
	// 3. write the test cases 
	
	
	@ParameterizedTest
	@CsvFileSource(
		files = "src/test/resources/names.csv", 
		lineSeparator = "|",
		numLinesToSkip = 1)
	void checkForMultipleNamesValidCaseCSVValues(String name) {
		assertTrue(tsc.checkName(name), "Invalid case for " + name);
	}
}






















