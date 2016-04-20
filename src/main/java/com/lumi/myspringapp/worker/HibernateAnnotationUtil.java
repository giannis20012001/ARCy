package com.lumi.myspringapp.worker;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateAnnotationUtil {

	private static final Logger logger = LoggerFactory.getLogger(HibernateAnnotationUtil.class);
	private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate-annotation.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("/hibernate.cfg.xml");
            logger.info("Hibernate Configuration created successfully");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            logger.info("ServiceRegistry created successfully");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            logger.info("SessionFactory created successfully");

            return sessionFactory;

        }
        catch (Throwable ex) {
        	logger.error("Initial SessionFactory creation failed.", ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);

        }

    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
        	sessionFactory = buildSessionFactory();

        }
        return sessionFactory;

    }

    public static void closeSessionFactory() {
        if (sessionFactory != null){
            sessionFactory.close();

        }

    }

}
