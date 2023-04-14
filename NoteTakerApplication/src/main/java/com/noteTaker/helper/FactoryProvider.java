package com.noteTaker.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

	public static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return factory;
	}
	
	public static void closeSessionFactory() {
		if(!factory.isClosed()) {
			factory.close();
		}
	}
}
