package com.ibm.business;

import java.util.ArrayList;
import java.util.List;

import com.ibm.api.IMessageService;

// MessageServiceImpl - SUT (System Under Test) 
// IMessageService - the dependency 
public class MessageServiceImpl {

	private IMessageService ims; 
	
	public MessageServiceImpl(IMessageService ims) {
		this.ims = ims; 
	}

	public List<String> getMessagesFromUser(String user) {
		List<String> filteredMessages = new ArrayList<>(); 
		List<String> messages = ims.getMessages(user);
		
		for(String message : messages) {
			if(message.contains(user)) {
				filteredMessages.add(message); 
			}
		}
		return filteredMessages; 
	}
}
