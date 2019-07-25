package com.qds.learning.springboot.dao.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.qds.learning.springboot.dao.support.HibernateAnnotationUtil;

public class OneToOneAssociationTest {

	private SessionFactory sessionFactory = HibernateAnnotationUtil
			.getSessionFactory();

	@Test
	public void testSavePerson() {
		Long personId = null;
		Long accountId = null;

		Account account = new Account("123-145-XX");
		Person person = new Person("Person 1");
		person.setAccount(account);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();

		accountId = (Long) session.save(account);
		personId = (Long) session.save(person);

		transaction.commit();

	}
}
