package com.test.testapp.dao;

import java.util.List;

import com.test.testapp.model.Person;

public interface PersonDAO {

	public void removePerson(int id);
	public void addPerson(Person p);
	public List<Person> getAllPersons();
}
