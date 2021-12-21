package com.edugrade.heartbeat.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public static EntityManager getEntityManager()  {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
