package com.ainosoft.loginGWT.server;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Configuration config;
	private static SessionFactory sessionfactory;
	
	static {
		config=new Configuration().configure("hibernate.cfg.xml");
	}
	
public static SessionFactory getSessionFactory() {
		
		sessionfactory=config.buildSessionFactory();
		return sessionfactory;
	}
}
