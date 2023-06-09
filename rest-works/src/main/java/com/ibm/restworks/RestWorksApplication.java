package com.ibm.restworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class RestWorksApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWorksApplication.class, args);
	}

	// http://localhost:9090/
	@GetMapping("/")
	public String hello() {
		return "hi"; 
	}
}
