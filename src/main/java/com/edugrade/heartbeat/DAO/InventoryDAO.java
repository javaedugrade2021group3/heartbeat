package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.InventoryEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class InventoryDAO implements DAOInterface <InventoryEntity>{

        @Override
        public void deleteEntryById(short id) {

        }

        @Override
public List<InventoryEntity> searchById(short id) {
        return null;
        }

@Override
public ObservableList<InventoryEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<InventoryEntity> inventoryEntityList = null;

        try {
        transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<InventoryEntity> query = entityManager.createQuery("from InventoryEntity", InventoryEntity.class);
        inventoryEntityList = query.getResultList();
        transaction.commit();

        } catch (Exception e) {
        if (transaction != null) {
        transaction.rollback();
        }
        e.printStackTrace();
        } finally {
        entityManager.close();
        }

        return FXCollections.observableArrayList(inventoryEntityList);

        }
}
