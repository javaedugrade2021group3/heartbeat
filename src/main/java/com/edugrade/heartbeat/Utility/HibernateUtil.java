package com.edugrade.heartbeat.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static Session getSession() {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure("persistence.xml").buildSessionFactory();
        Session session;
        session = sessionFactory.openSession();
        return session;
    }
}
