package com.ty_many_to_many_person_lang_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty_many_to_many_person_lang_uni.DAO.LanguageDAO;
import com.ty_many_to_many_person_lang_uni.DAO.PersonDAO;
import com.ty_many_to_many_person_lang_uni.dto.Language;
import com.ty_many_to_many_person_lang_uni.dto.Person;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter choice to add \n1:add 2 languages details \n2:add 2 persons details \n3update details \n4:delete details");
		int choice = scanner.nextInt();
		PersonDAO dao = new PersonDAO();
		LanguageDAO dao2 = new LanguageDAO();
		List<Language> list = new ArrayList<Language>();
		List<Person> list1 = new ArrayList<Person>();

		switch (choice) {
		case 1: {
			int num = 1;
			while (num <= 2) {
				Language l1 = new Language();

				System.out.println("Enter id of language");
				int id = scanner.nextInt();
				System.out.println("Enter name of language");
				String name = scanner.next();
				System.out.println("Enter origin of language");
				String origin = scanner.next();
				System.out.println("Enter country of language");
				String country = scanner.next();

				l1.setId(id);
				l1.setName(name);
				l1.setOrigin(origin);
				l1.setCountry(country);

				list.add(l1);
				num++;

			}
//			
		}
		// end case
		case 2: {
			int num = 1;
			while (num <= 2) {
				Person p1 = new Person();
				System.out.println("Enter id of person");
				int id = scanner.nextInt();
				System.out.println("Enter name of person");
				String name = scanner.next();
				System.out.println("Enter address of person");
				String address = scanner.next();
				System.out.println("Enter phone of person");
				long phone = scanner.nextLong();
				p1.setId(id);
				p1.setName(name);
				p1.setPhone(phone);
				p1.setAddress(address);

				list1.add(p1);
				num++;

				p1.setLanguages(list);

			}
			dao2.saveLanguage(list);
			dao.savePerson(list1);

		} // end case
		case 3: {
			System.out.println("Enter choice to update \n1:Person \n:2language");
			int choice1 = scanner.nextInt();
			switch (choice1) {
			case 1: {
				System.out.println("Enter id of person");
				int id = scanner.nextInt();
				System.out.println("Enter to change name");
				String name = scanner.next();
				Person p1 = new Person();
				p1.setId(id);
				p1.setName(name);
				dao.updatePerson(p1);
			}
				break;// case end
			case 2: {
				System.out.println("Enter id of lang");
				int id = scanner.nextInt();
				System.out.println("Enter to change name");
				String name = scanner.next();
				Language p1 = new Language();
				p1.setId(id);
				p1.setName(name);
				dao2.updateLanguage(p1);
			} // case end
			}// switch
		} // end case
			break;
		case 4: {
			System.out.println("Enter choice to delete \n1:Person \n:2language");
			int choice1 = scanner.nextInt();
			switch (choice1) {
			case 1: {
				System.out.println("Enter id of person");
				int id = scanner.nextInt();

				Person p1 = new Person();
				p1.setId(id);

				dao.removePerson(p1);
			}
				break;// case end
			case 2: {
				System.out.println("Enter id of lang");
				int id = scanner.nextInt();

				Language p1 = new Language();
				p1.setId(id);

				dao2.removeLanguage(p1);
			} // case end
			}// switch
		} // end case
		case 5:{
			System.out.println("Enter id of person");
			Person p1 = new Person();
			int id = scanner.nextInt();
			p1.setId(id);
			dao.getPersonById(p1);

		}//end case
		}// switch

	}
}
