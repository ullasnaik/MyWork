package com.ullas.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {

			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("com/ullas/resources/hibernate.cfg.xml").build();
			System.out.println("Hibernate Configuration loaded");

			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();

			System.out.println("Hibernate serviceRegistry created");
			return metadata.getSessionFactoryBuilder().build();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

}