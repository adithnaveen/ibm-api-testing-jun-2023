package com.ibm.api.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.api.IMessageService;
import com.ibm.business.MessageServiceImpl;

class MessageServiceTestMock02 {

	@Test
	@DisplayName("sample testing for message service using mock stub ")
	void testMessageServiceWithMockStub() {
		
		List<String> messages = Arrays.asList(
				"hello from maya", 
				"good morning from mohit", 
				"maya and sanmeet are attending session",
				"bhawesh is doing online session");

		IMessageService messageServiceMock = mock(IMessageService.class); 
		
		when(messageServiceMock.getMessages("maya")).thenReturn(messages);
		
		MessageServiceImpl messageServiceImpl = new MessageServiceImpl(messageServiceMock); 
		List<String> filteredMessages = messageServiceImpl.getMessagesFromUser("maya");
		
		assertEquals(2, filteredMessages.size());
		
	}

	@Test
	@DisplayName("to test empty list of messages valid case ")
	void testEmptyList() {
		List<String> list = new ArrayList<>();
		
		IMessageService messageSercieMock = mock(IMessageService.class);
		when(messageSercieMock.getMessages("devi")).thenReturn(list); 
		
		MessageServiceImpl messageServiceImpl = new MessageServiceImpl(messageSercieMock);
		
		List<String> filteredList = messageServiceImpl.getMessagesFromUser("devi");
		assertEquals(0, filteredList.size());
	}
	
}








