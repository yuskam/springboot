package com.qds.learning.springboot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.qds.learning.springboot.dao.domain.Cart;
import com.qds.learning.springboot.dao.domain.Item;
import com.qds.learning.springboot.dao.support.HibernateAnnotationUtil;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class CartRepositoryTest {

	private SessionFactory sessionFactory;

	@Test
	public void testSaveCart() {
		Cart cart = new Cart();

		Item item1 = new Item("item 1", cart);
		Item item2 = new Item("item 2", cart);

		cart.setItems(item1, item2);

		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session created");

		Transaction tx = session.beginTransaction();

		session.save(cart);
		// session.save(item1);
		// session.save(item2);
		tx.commit();
		System.out.println("Cart ID=" + cart.getId());
		System.out.println("item1 ID=" + item1.getId()
				+ ", Foreign Key Cart ID=" + item1.getCart().getId());
		System.out.println("item2 ID=" + item2.getId()
				+ ", Foreign Key Cart ID=" + item2.getCart().getId());
	}
}
