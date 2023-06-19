package com.ibm.business.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ibm.business.EmployeeList;

class EmployeeListTest {

	// this test method shall test the stub 
	@Test
	void testEmployeesWithoutMock() {
		List<String> list = new EmployeeList().getEmployees(); 
		assertTrue(list.size()>0);
	}

	// same test with mock 
	
	@Test
	void testListOfEmployeesWithList() {
		List mockList = mock(List.class);

		when(mockList.size()).thenReturn(5); 
		
		assertEquals(5, mockList.size());
		
	}
}
