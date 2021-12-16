package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.CustomerEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDAO implements DAOInterface<CustomerEntity> {

    @Override
    public ObservableList<CustomerEntity> searchById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CustomerEntity> customerEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CustomerEntity> query = entityManager.createQuery("from CustomerEntity where customerId = ?1", CustomerEntity.class);
            query.setParameter(1, id);
            customerEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(customerEntityList);
    }

    @Override
    public ObservableList<CustomerEntity> getAll() {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CustomerEntity> customerEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CustomerEntity> query = entityManager.createQuery("from CustomerEntity", CustomerEntity.class);
            customerEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(customerEntityList);
    }
}
