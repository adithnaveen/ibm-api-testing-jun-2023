package com.ibm.api.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ibm.api.IMessageService;
import com.ibm.business.MessageServiceImpl;

class ListMockWithSpy04 {

	@Test
	void testMessageServiceWithSpy() {
		 IMessageService messageServiceSpy = spy(IMessageService.class);
		 
		 // in spy you shall have real implmentation -like arraylist 
		 
		 List messages = spy(ArrayList.class);
		 
		 messages.add("Hello from naveen"); 
		 messages.add("today weather in bengaluru is rainy"); 
		 messages.add("we are heading to mockito"); 
		 messages.add("mockito helps us to mock");
		 
		 
		 System.out.println(messages);
		 
		 when(messageServiceSpy.getMessages("mockito")).thenReturn(messages); 
		 messageServiceSpy.getMessages("mockito"); 
		 
		 
		 MessageServiceImpl messageServiceImpl = new MessageServiceImpl(messageServiceSpy); 
		 List<String> filteredMessages = messageServiceImpl.getMessagesFromUser("mockito");
		 
		 assertEquals(2, filteredMessages.size());
	}

}
