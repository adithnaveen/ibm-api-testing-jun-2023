package com.ibm.restworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.restworks.entity.Person;
import com.ibm.restworks.respository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepo;
	
	public Person addPerson(Person person) {
		return personRepo.save(person); 
	}
	
	public List<Person> getAllPersons() {
		return personRepo.findAll(); 
	}
	
	public Person getPersonById(String id) {
		Optional<Person> optional = personRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get(); 
		}
		
		return null; 
	}
}
