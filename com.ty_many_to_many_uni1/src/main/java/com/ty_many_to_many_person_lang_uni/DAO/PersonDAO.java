package com.ty_many_to_many_person_lang_uni.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty_many_to_many_person_lang_uni.dto.Person;

public class PersonDAO {
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void savePerson(List<Person> list) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		for (Person person : list) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
		}

	}
	
	public void updatePerson(Person person) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person p2=entityManager.find(Person.class, person.getId());
		p2.setName(person.getName());
		entityTransaction.begin();
		entityManager.merge(p2);
		entityTransaction.commit();
	}
	
	public void removePerson(Person person) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person p2=entityManager.find(Person.class, person.getId());
		entityTransaction.begin();
		entityManager.remove(p2);
		entityTransaction.commit();
	}
	
	public void getPersonById(Person person) {
		EntityManager entityManager = geEntityManager();
	
		Person p2=entityManager.find(Person.class, person.getId());
		List<Person> list = new ArrayList<Person>();
		list.add(p2);
		System.out.println(list);
	}
}












