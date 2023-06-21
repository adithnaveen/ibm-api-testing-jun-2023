package com.ibm.restworks.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

class RestAssuredEx02 {
	@BeforeEach
	public void setUp() {
		baseURI = "https://jsonplaceholder.typicode.com";
	}

	// is in BDD Style
	@Test
	void testExtractDetailsUsingPathForImageUrl() {

		String path =
				// pre condition
				given().header("Content-Type", "application/json")
//			.header("Bearer ", "SomeTokenNumber")

						// actual execution
						.when().get("/photos/1")
						// post condition
						.then().contentType(ContentType.JSON).body("albumId", equalTo(1)).extract().path("url")
						.toString();

		// once you get the path make another request for checking image exists
		when().get(path).then().statusCode(200);
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
		Response response = when().get("/photos/1").then().extract().response();

//		System.out.println(response.contentType()); 
//		System.out.println(response.statusCode());
	}

	@Test
	public void testExtractUsersAndConvertToJsonAssert10UsersExists_v1() {

		String retData = when().get("/users").then().extract().asString();

		System.out.println(retData);
		JsonPath jsonPath = new JsonPath(retData);
		List<String> list = jsonPath.get("name");

		assertEquals(10, list.size());

	}

	@Test
	public void testExtractUsersAndConvertToJsonAssert10UsersExists_v2() {
		String retData = get("/users").then().extract().asString();

		List<String> list = new JsonPath(retData).get("name");

		assertEquals(10, list.size());

	}

	// check if the API has headers
	@Test
	public void testExtractHeaderInformation() {
		Response response = get("/users");

		Headers headers = response.getHeaders();

		headers.forEach((header) -> System.out
				.println("Header Name " + header.getName() + 
						" Header Value " + header.getValue()));

		String contentType = response.getHeader("Content-Type");

		assertEquals("application/json; charset=utf-8", contentType);

		String expires = response.getHeader("Expires");

		assertEquals("-1", expires);

	}

	
	// to extract cookie information 
	
	@Test 
	public void testExtractCookie() {
		Response response = get("/users");
		 Map<String, String> cookies = response.getCookies(); 
		System.out.println("lenght of cookies " + cookies.size());
		
		System.out.println(cookies );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
