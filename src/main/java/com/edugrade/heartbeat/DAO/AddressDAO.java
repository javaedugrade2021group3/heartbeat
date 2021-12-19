package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.AddressEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressDAO implements DAOInterface<AddressEntity>{


    @Override
    public void deleteEntryById(short id) {

    }

    @Override
    public List<AddressEntity> searchById(short Id) {
        return null;
    }

    @Override
    public ObservableList<AddressEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<AddressEntity> addressEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<AddressEntity> query = entityManager.createQuery("from AddressEntity", AddressEntity.class);
            addressEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(addressEntityList);
    }
}
