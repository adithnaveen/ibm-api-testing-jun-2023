package com.ibm.restworks.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.restworks.entity.Person;
import com.ibm.restworks.service.PersonService;

@RestController
@RequestMapping("/api/person")	// http://localhost:9090/api/person
public class PersonController {

	@Autowired
	private PersonService service; 
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		return service.addPerson(person); 
	}
	// http://localhost:9090/api/person
	@GetMapping
	public List<Person> getPersons() {
		return service.getAllPersons(); 
	}
	
	// http://localhost:9090/api/person/649287dcf001233f806e6cb7
	@GetMapping(value = "/{id}")
	public Person getById( @PathVariable("id")  String id) {
		return service.getPersonById(id); 
	}
	
}
