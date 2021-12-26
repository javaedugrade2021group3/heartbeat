package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.CustomerAddressEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.*;
import java.util.List;

public class CustomerAddressDAO implements DAOInterface<CustomerAddressEntity> {

    @Override
    public void deleteEntryById(short id) {
    }

    @Override
    public ObservableList<CustomerAddressEntity> searchById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CustomerAddressEntity> customerAddressEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CustomerAddressEntity> query = entityManager.createQuery("from CustomerAddressEntity where customerId =?1", CustomerAddressEntity.class);
            query.setParameter(1, id);
            customerAddressEntityList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(customerAddressEntityList);
    }

    @Override
    public ObservableList<CustomerAddressEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CustomerAddressEntity> customerAddressEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CustomerAddressEntity> query = entityManager.createQuery("from CustomerAddressEntity", CustomerAddressEntity.class);
            customerAddressEntityList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(customerAddressEntityList);
    }
}
