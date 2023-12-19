package net.horvoje.querydsl.bugs.contains;

import java.awt.print.Book;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionFactoryMaker {

	private static SessionFactory factory;

	private static void configureFactory() {
		try {
			factory = new Configuration().addAnnotatedClass(Book.class).configure().buildSessionFactory();
		}
		catch (final Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static org.hibernate.SessionFactory getFactory() {
		if (factory == null) {
			configureFactory();
		}
		return factory;
	}

}
