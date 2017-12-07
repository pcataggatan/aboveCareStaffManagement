package edu.matc.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * This utility class creates and returns a Session Factory.
 * @author Pablo Cataggatan
 */
public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    /**
     * Creates a Session Factory
     */
    public static void createSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Gets the Session Factory.
     * @return the Session Factory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;

    }
}
