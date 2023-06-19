package com.ibm.business.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ibm.business.ITestingSampleCode;
import com.ibm.business.TestingSampleCode;

class TestingSampleCodeTest {

	@BeforeAll
	static void initialize() {
		System.out.println("Your Initialization goes here ");
	}
	
	@AfterAll
	static void tearDownLast() {
		System.out.println("I'm the last one to go ");
	}
	ITestingSampleCode tsc ; 
	
	@BeforeEach
	void setUp() {
		tsc = new TestingSampleCode();
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	public void sampleTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void sayHelloToTheNameSent() {
		String name = "Aswini"; 
		assertEquals("Hello " + name , tsc.sayHello(name));
	}
}
