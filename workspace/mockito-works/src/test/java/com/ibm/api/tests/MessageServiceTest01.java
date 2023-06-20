package com.ibm.api.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.api.IMessageService;
import com.ibm.business.MessageServiceImpl;
import com.ibm.data.api.MessageSercieStub;

class MessageServiceTest01 {

	@Test
	@DisplayName("testing with the stub for message service ")
	void testMessageServiceUsingStub() {
		// you have reference of an object which can give you data
		IMessageService ims = new MessageSercieStub();

		// system under test
		MessageServiceImpl msi = new MessageServiceImpl(ims);

		List<String> filteredList = msi.getMessagesFromUser("maya");
		System.out.println(filteredList);
		assertEquals(2, filteredList.size());

	}

	// TODO implement the deleteMessage test case 
}
