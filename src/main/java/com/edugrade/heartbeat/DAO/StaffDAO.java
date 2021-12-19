package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.StaffEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class StaffDAO implements DAOInterface<StaffEntity> {

    @Override
    public void deleteEntryById(short id) {

    }

    @Override
    public ObservableList<StaffEntity> searchById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<StaffEntity> staffEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<StaffEntity> query = entityManager.createQuery("from StaffEntity where staffId = ?1", StaffEntity.class);
            query.setParameter(1, id);
            staffEntityList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }

        return FXCollections.observableArrayList(staffEntityList);
    }

    @Override
    public ObservableList<StaffEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<StaffEntity> staffEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<StaffEntity> query = entityManager.createQuery("from StaffEntity", StaffEntity.class);
            staffEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(staffEntityList);
    }
}
