package com.ibm.restworks.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

class RestAssuredEx03 {

	/**
	 * Reference : 
	 * {
        "id": 1,
        "title": "json-server",
        "author": "typicode"
    	}
	 */
	@Test
	void testToPostData() {
		 baseURI ="http://localhost:3000"; 
		 
		 Map<String, Object> map = new HashMap<String, Object>(); 
		 map.put("id", 3); 
		 map.put("title", "World Is Great"); 
		 map.put("author", "Somebody"); 
		 
		 JSONObject jsonReqObject = new JSONObject(map); 
		 
		 System.out.println(jsonReqObject.toJSONString()); 
		 
		 given()
		 	.header("Content-Type", "application/json")
		 	.accept(ContentType.JSON)
		 	.body(jsonReqObject.toJSONString())
		 .when()
		 	.post("/posts")
		 .then()
		 	.statusCode(201)
		 	.log()
		 	.all();
		 	
	}

	

	// only for testing  
	@Test
	void testNestedPosts() {
		
		
		JSONObject author = new JSONObject(); 
		author.put("firstName", "Kumar");
		author.put("lastName", "Naveen"); 
		
		 Map<String, Object> map = new HashMap<String, Object>(); 
		 map.put("id", 4); 
		 map.put("title", "World Is Great again "); 
		 map.put("author", author); 
		 
		 JSONObject jsonReqObject = new JSONObject(map); 
		 
		 
		 given()
		 	.header("Content-Type", "application/json")
		 	.accept(ContentType.JSON)
		 	.body(jsonReqObject.toJSONString())
		 .when()
		 	.post("/posts")
		 .then()
		 	.statusCode(201)
		 	.log()
		 	.all();
	}
	
	
	// TODO 
	void testToUpdateTitle() {
		
	}
	
	void testToDeleteWithId() {
		
	}
	
	
	
	
	
	
	
	
	
}
