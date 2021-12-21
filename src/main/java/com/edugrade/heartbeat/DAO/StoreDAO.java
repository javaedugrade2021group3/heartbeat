package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.StoreEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class StoreDAO implements DAOInterface<StoreEntity>{


    @Override
    public void deleteEntryById(short id) {

    }

    @Override
    public List<StoreEntity> searchById(short id) {
        return null;
    }

    @Override
    public ObservableList<StoreEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<StoreEntity> storeEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<StoreEntity> query = entityManager.createQuery("from StoreEntity", StoreEntity.class);
            storeEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(storeEntityList);
    }

}
