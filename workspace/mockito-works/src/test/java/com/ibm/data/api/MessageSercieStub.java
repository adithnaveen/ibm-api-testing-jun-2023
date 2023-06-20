package com.ibm.data.api;

import java.util.Arrays;
import java.util.List;

import com.ibm.api.IMessageService;

public class MessageSercieStub implements IMessageService {

	@Override
	public List<String> getMessages(String user) {
		// this shall return the data

		return 
		Arrays.asList(
				"hello from maya", 
				"good morning from mohit", 
				"maya and sanmeet are attending session",
				"bhawesh is doing online session");
	}
 
}
