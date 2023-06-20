package com.ibm.api.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListMockTest03 {

	@Test
	void mockListSize() {
		 List listMock = mock(List.class);
		 when(listMock.size()).thenReturn(5); 
		 assertEquals(5, listMock.size());
	}

	@Test
	void mockListSizeMultipleValues() {
		List listMock = mock(List.class);
		 when(listMock.size()).thenReturn(5).thenReturn(10); 
		 
		 assertEquals(5, listMock.size());
		 assertEquals(10, listMock.size());
		 
	}
	
	
	@Test
	@DisplayName("to mock the list with any int to get the name")
	void mockListForGetValues() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("Naveen"); 
		
		assertEquals("Naveen", listMock.get(0));
		assertEquals("Naveen", listMock.get(3)); 
	}
	
	@Test
	@DisplayName("to throw an exception when any int is passed")
	void mockListToThrowException() {
		List listMock = mock(List.class);
		 
		when(listMock.get(anyInt())).thenThrow(new RuntimeException()); 
		
		assertThrows(RuntimeException.class, () -> listMock.get(0)); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
