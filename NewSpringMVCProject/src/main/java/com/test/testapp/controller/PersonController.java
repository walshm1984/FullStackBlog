package com.test.testapp.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.testapp.model.Person;
import com.test.testapp.service.IPersonService;
import com.test.testapp.service.PersonService;

@Controller
@RequestMapping("/Person")
public class PersonController {

	private IPersonService personService;

	@Autowired(required=true)
	@Qualifier(value = "personService")
	public void setPersonService(IPersonService ps) {
		this.personService = ps;
	}

	@RequestMapping(value = "/add/{name}/{country}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object addPerson(@PathVariable("name") String name, @PathVariable("country") String country) {

		class PersonSuccess implements Serializable {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private Person person;
			private boolean addedSuccessully;
			private String error;

			PersonSuccess(Person mPerson, boolean added) {
				this.person=mPerson;
				setAddedSuccessully(added);
			}

			public String getError() {
				return error;
			}

			public void setError(String error) {
				this.error = error;
			}

			public boolean isAddedSuccessully() {
				return addedSuccessully;
			}

			public void setAddedSuccessully(boolean addedSuccessully) {
				this.addedSuccessully = addedSuccessully;
			}

			public Person getPerson() {
				return person;
			}


		}
		Person mPerson = new Person();
		mPerson.setName(name);
		mPerson.setCountry(country);
		PersonSuccess mSuc = new PersonSuccess(mPerson, false);
		try {
			this.personService.addPerson(mPerson);
			mSuc.setAddedSuccessully(true);
		} catch (Exception e) {
			mSuc.setError(e.toString());
		}

		return mSuc;
	}
	
	@RequestMapping(value = "/All", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getAll() {
	
		return personService.getPersonList();
	}

	@RequestMapping(value = "/Remove/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object removePerson(@PathVariable("id") int id) {
		class RemoveSuccess implements Serializable {
			private static final long serialVersionUID = 1L;

			RemoveSuccess(int id, boolean success) {
				removedID = id;
				removedSuccessful = success;

			}

			private int removedID;
			private boolean removedSuccessful;
			private String exception;

			public int getRemovedID() {
				return removedID;
			}

			public boolean isRemovedSuccessful() {
				return removedSuccessful;
			}

			public String getException() {
				return exception;
			}

			public void setException(String exception) {
				this.exception = exception;
			}

			public void setRemovedSuccess(boolean succ) {
				this.removedSuccessful = succ;
			}
		}
		RemoveSuccess mSuc = new RemoveSuccess(id, false);

		try {
			personService.removePerson(id);
			mSuc.setRemovedSuccess(true);
		} catch (Exception e) {
			mSuc.setException(e.toString());
		}

		return mSuc;
	}
}
