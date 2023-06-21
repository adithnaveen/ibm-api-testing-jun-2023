package com.ibm.restworks.tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

class RestAssuredEx02 {
	@BeforeEach
	public void setUp() {
		baseURI="https://jsonplaceholder.typicode.com";
	}
	// is in BDD Style 
	@Test
	void testExtractDetailsUsingPathForImageUrl() {
	
		String path = 
		when()
			.get("/photos/1")
		.then()
			.contentType(ContentType.JSON)
			.body("albumId", equalTo(1)).extract().path("url").toString();
		 
		// once you get the path make another request for checking image exists 
		when()
			.get(path)
		.then()
			.statusCode(200);
	}

	// extracting the path with single liner 
	@Test
	void testExtractDetailsUsingPathForThumbNail() {
		
		String thumbnailUrl = get("https://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");

		get(thumbnailUrl).then().statusCode(200);
	}

	// using response object 
	@Test
	void testExtractDetailsUsingPathForUrlUsingResponse() {
		Response response = when()
			.get("/photos/1")
		.then()
			.extract()
			.response(); 
			

		System.out.println(response.contentType()); 
		System.out.println(response.statusCode());
	}
	
}










