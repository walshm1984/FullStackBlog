package com.test.testapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.test.testapp.model.Person;
@Repository
public class PersonDAOMYSql implements PersonDAO {

	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	
	
	@Override
	public void removePerson(int id) {
		 Session session = this.sessionFactory.getCurrentSession();
	        Person p = (Person) session.load(Person.class, new Integer(id));
	        if(p!=null){
	            session.delete(p);
	        }
	}

	@Override
	public void addPerson(Person p) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.persist(p);
	}

	@Override
	public List<Person> getAllPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
		return personsList;
	}

}
