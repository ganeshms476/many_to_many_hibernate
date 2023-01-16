package com.ty_many_to_many_person_lang_uni.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty_many_to_many_person_lang_uni.dto.Language;
import com.ty_many_to_many_person_lang_uni.dto.Person;

public class LanguageDAO {
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveLanguage(List<Language> list) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		for (Language language : list) {
			entityTransaction.begin();
			entityManager.persist(language);
			entityTransaction.commit();
		}

	}

	public void updateLanguage(Language lang) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Language p2 = entityManager.find(Language.class, lang.getId());
		p2.setName(lang.getName());
		entityTransaction.begin();
		entityManager.merge(p2);
		entityTransaction.commit();
	}
	
	
	public void removeLanguage(Language lang) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Language p2=entityManager.find(Language.class, lang.getId());
		entityTransaction.begin();
		entityManager.remove(p2);
		entityTransaction.commit();
	}
}
