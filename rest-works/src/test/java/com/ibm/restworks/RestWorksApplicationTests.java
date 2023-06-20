package com.ibm.restworks;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ibm.restworks.entity.Person;
import com.ibm.restworks.respository.PersonRepository;
import com.ibm.restworks.service.PersonService;

@SpringBootTest
class RestWorksApplicationTests {

	
	@MockBean
	PersonRepository repository; 
	
	@Autowired
	PersonService service; 
	
	
	@Test
	@DisplayName("To get person by id by mocked repository")
	public void shouldGetPersonByIdValidCase() {
		Person p1 = new Person(); 
		
		p1.setId("1234");
		p1.setName("Roshanth");
		p1.setCity("Bengaluru");
		p1.setEmail("roshanth@ibm.com");
		p1.setPhone("9900887766");
		
		Mockito.when(repository.findById("1234")).thenReturn(Optional.of(p1)); 
		
		
		// tests 
		Person retPerson = service.getPersonById("1234"); 
		assertEquals("Roshanth", retPerson.getName());
	}
	
}
















