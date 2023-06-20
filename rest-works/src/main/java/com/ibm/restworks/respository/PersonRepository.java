package com.ibm.restworks.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.restworks.entity.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

	// when you have an interface extending MongoRepository you will get implicit
	// CRUD operations 
}
