package com.test.testapp.service;

import java.util.List;

import com.test.testapp.model.Person;

public interface IPersonService {

	public void addPerson(Person p);
	public List<Person> getPersonList();
	public void removePerson(int id);
}
