package com.ibm.api.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibm.api.IMessageService;
import com.ibm.business.MessageServiceImpl;


@ExtendWith(MockitoExtension.class)
class MessageServiceMOckTestWithAnnotation05 {

	@Mock
	IMessageService messageService; 
	
	@InjectMocks
	MessageServiceImpl messageServiceImpl; 
	
	
	@Test
	void testMessageServiceImplWithMockAnnotation() {
		List<String> messages = Arrays.asList(
				"this is my first message naveen", 
				"naveen lives in bengaluru", 
				"people attend classroom or online traingin"); 
		
		
		when(messageService.getMessages("naveen")).thenReturn(messages); 
		List<String> filteredMessages = messageServiceImpl.getMessagesFromUser("naveen");
		
		assertEquals(2, filteredMessages.size());
		
		
	}

}
















