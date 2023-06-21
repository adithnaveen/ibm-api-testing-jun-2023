package com.ibm.restworks.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

class RestAssuredEx01 {

	@BeforeEach
	public void setUp() {
		baseURI="https://jsonplaceholder.typicode.com";
	}
	
	@Test
	@DisplayName("to check json place holder is up and get meta data")
	void checkIfSiteIsUp() {
		Response response = get("/users");
		long time = response.getTime();
		int statusCode = response.getStatusCode();
		Map<String, String> cookies = response.getCookies();
		String header = response.getHeader("content-type");
		String body = response.getBody().asString();
		
		System.out.println("Time Taken " + time);
		System.out.println("Status Code " + statusCode);
		System.out.println("Cookies " + cookies);
		System.out.println("Header Information " + header);
		System.out.println("Body " + body);
	}
	
	
	@Test 
	void logErrorWhenServerIdNotAvailable() {
		when()
			.get("/users")
		.then()
			.log()
			.ifError(); 
	}
	@Test 
	void checkIfTheTestCasePassInStipulatedTime1000Ms() {
		when()
			.get("/users")
		.then()
		.time(Matchers.lessThan(1L), TimeUnit.SECONDS)
		.log()
		.ifError(); 
	}
	
}
