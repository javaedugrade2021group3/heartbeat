package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.StaffAddressEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class StaffAddressDAO implements DAOInterface<StaffAddressEntity> {
    @Override
    public void deleteEntryById(short id) {

    }

    @Override
    public ObservableList<StaffAddressEntity> searchById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<StaffAddressEntity> staffAddressEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<StaffAddressEntity> query = entityManager.createQuery("from StaffAddressEntity where staffId =?1", StaffAddressEntity.class);
            query.setParameter(1, id);
            staffAddressEntityList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(staffAddressEntityList);
    }

    @Override
    public List getAll() {
        return null;
    }
}
