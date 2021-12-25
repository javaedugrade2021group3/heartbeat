package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.StoreAddressEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class StoreAddressDAO implements DAOInterface{
    @Override
    public void deleteEntryById(short id) {

    }

    @Override
    public ObservableList<StoreAddressEntity> searchById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<StoreAddressEntity> customerStoreAddressEntities = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<StoreAddressEntity> query = entityManager.createQuery("from StoreAddressEntity where storeId =?1", StoreAddressEntity.class);
            query.setParameter(1, id);
            customerStoreAddressEntities = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(customerStoreAddressEntities);
    }

    @Override
    public List getAll() {
        return null;
    }
}
