package com.edugrade.heartbeat.DAO;


import com.edugrade.heartbeat.Model.RentalEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class RentalDAO implements DAOInterface <RentalEntity> {

    @Override
    public List<RentalEntity> searchById(short id) {
    return null;
    }

    @Override
    public ObservableList<RentalEntity> getAll() {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<RentalEntity> rentalEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<RentalEntity> query = entityManager.createQuery("from RentalEntity", RentalEntity.class);
            rentalEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(rentalEntityList);
    }
}
