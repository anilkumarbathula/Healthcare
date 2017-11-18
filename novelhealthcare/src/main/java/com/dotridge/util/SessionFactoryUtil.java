package com.dotridge.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactoryUtil 
{
	private static final SessionFactory sessionFactory = buildSessionFactoryInClass();

	private SessionFactoryUtil()
	{
		
	}
	
	private static SessionFactory buildSessionFactoryInClass() 
	{
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		return configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
