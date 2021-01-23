package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

		// builds a session factory from the service registry
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();

//		Author a1 = new Author("Kevin", "kevin@gmail.com");
//		Author a2 = new Author("James", "james@gmail.com");
//
//		Set<Author> javaAuthor = new HashSet<Author>();
//		Set<Author> cAuthoe = new HashSet<Author>();
//		Set<Author> pascalAuthor = new HashSet<Author>();
//
//		javaAuthor.add(a1);
//		javaAuthor.add(a2);
//		cAuthoe.add(a1);
//		pascalAuthor.add(a2);
//
//		Book b1 = new Book("Java", javaAuthor);
//		Book b2 = new Book("C", cAuthoe);
//		Book b3 = new Book("Pascal", pascalAuthor);
//		session.save(b1);
//		session.save(b2);
//		session.save(b3);

		Book a1 = (Book) session.load(Book.class, 1L);
		System.out.println(a1.getAuthors());
		session.getTransaction().commit();
		session.close();

	}

}
