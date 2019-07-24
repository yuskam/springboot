package com.qds.learning.springboot.dao.support;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateAnnotationUtil {

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();

		Metadata metadata = new MetadataSources(serviceRegistry)
				.getMetadataBuilder().build();
		return metadata.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();

		return sessionFactory;
	}
}
