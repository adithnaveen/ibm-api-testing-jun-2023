package com.ibm.business;

public class NameInvalidException extends RuntimeException{
	private String msg; 
	
	public NameInvalidException() {
		this.msg = "Invalid Name"; 
	}
	
	public NameInvalidException(String msg) {
		this.msg = msg; 
	}

	@Override
	public String toString() {
		return "NameInvalidException [msg=" + msg + "]";
	}
	
	
}
