package com.test.testapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.testapp.dao.PersonDAO;
import com.test.testapp.model.Person;
@Service
public class PersonService implements IPersonService {
	
	 private PersonDAO personDAO;
	 
	    public void setPersonDAO(PersonDAO personDAO) {
	        this.personDAO = personDAO;
	    }
	
	@Override
	@Transactional
	public void addPerson(Person p) {

		personDAO.addPerson(p);
	}
	@Override
	@Transactional
	public List<Person> getPersonList() {

		return personDAO.getAllPersons();
	}
	
	@Override
	@Transactional
	public void removePerson(int id) {

		personDAO.removePerson(id);
	}

}
