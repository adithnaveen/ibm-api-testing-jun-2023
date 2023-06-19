package com.ibm.business.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.ibm.business.ITestingSampleCode;
import com.ibm.business.NameInvalidException;
import com.ibm.business.TestingSampleCode;

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
	ITestingSampleCode tsc ;
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
	
	@Test
	public void sampleTest() {
		assertEquals(true, true);
	}
	
	@Test
	@DisplayName("To test the name with valid case and say hello")
	public void sayHelloToTheNameSentValidCase() {
		String name = "Aswini"; 
		assertEquals("Hello " + name , tsc.sayHello(name));
	}

	@Test
	@DisplayName("To check if the name passed is more than 4 chars valid case ")
	public void checkNamePassedMoreThanFourChars() {
		assertTrue(tsc.checkName(validCaseName));
	}
	

	@Test
	@DisplayName("To check if the name passed is less than 4 chars valid case ")
	public void checkNamePassedLessThanFourChars() {
		// have to checkAgainst exception
		
		NameInvalidException nameInvalidException = assertThrows(NameInvalidException.class, 
				new Executable() {
					
					@Override
					public void execute() throws Throwable {
						tsc.checkName(invalidCaseName);
					}
				}, 
				"Sorry the name passed is not valid");
		
		assertEquals("Name Not Valid " + invalidCaseName, 
					nameInvalidException.getMessage());
	}
	
	@Test
	@DisplayName("To check if the name passed is less than 4 chars valid case-Lambda ")
	public void checkNamePassedLessThanFourCharsWithLambda() {
		// have to checkAgainst exception
		
		NameInvalidException nameInvalidException = assertThrows(NameInvalidException.class, 
				() -> tsc.checkName(invalidCaseName) , 
				"Sorry the name passed is not valid");
		
		assertEquals("Name Not Valid " + invalidCaseName, 
					nameInvalidException.getMessage());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
