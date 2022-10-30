/**
 * 
 */
package com.bomweb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author SACHIN
 *
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new Configuration();
			//sessionFactory = configuration.configure().buildSessionFactory();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration
					.buildSessionFactory(new ServiceRegistryBuilder()
							.applySettings(configuration.getProperties())
							.buildServiceRegistry());

		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}