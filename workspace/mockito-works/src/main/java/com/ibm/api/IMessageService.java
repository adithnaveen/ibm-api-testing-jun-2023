package com.ibm.api;

import java.util.List;

// this is a contract 
public interface IMessageService {
	public List<String> getMessages(String user);
	
	// you can multiple methods over a course of time 
	// add, delete, get all, update etc etc... 
	
//	 public void deleteMessageFromUser(String user); 
	
}
