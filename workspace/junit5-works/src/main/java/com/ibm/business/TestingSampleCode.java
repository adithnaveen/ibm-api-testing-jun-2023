package com.ibm.business;

import java.util.List;

public class TestingSampleCode implements 
	ITestingSampleCode{

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public List<String> getNames() {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return List.of("Maya", "Mohit", "Roshanth", "Hiranmai"); 
	}

	@Override
	public boolean checkName(String name) {
		if(name.length()< 4 ) {
			throw new NameInvalidException("Name Not Valid " + name);
		}
		return true;  
	}

}
