package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.StaffEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class StaffDAO implements DAOInterface<StaffEntity> {

    public void updateStaff(short id, String firstName, String lastName, short addressId, String email, byte storeId, byte active, String username, String password) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        Date date = new Date();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            StaffEntity staff = entityManager.find(StaffEntity.class, id);
            entityManager.detach(staff);
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setAddressId(addressId);
            staff.setEmail(email);
            staff.setStoreId(storeId);
            staff.setActive(active);
            staff.setUsername(username);
            staff.setPassword(password);
            staff.setLastUpdate(new Timestamp(date.getTime()));
            entityManager.merge(staff);
            entityManager.flush();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void addNewStaff(String firstName, String lastName, short addressId, String email, byte storeId, byte active, String username, String password) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        Date date = new Date();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            StaffEntity staff = new StaffEntity();
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setAddressId(addressId);
            staff.setEmail(email);
            staff.setStoreId(storeId);
            staff.setUsername(username);
            staff.setPassword(password);
            staff.setActive(active);
            staff.setLastUpdate(new Timestamp(date.getTime()));
            entityManager.persist(staff);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteEntryById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM StaffEntity s where s.staffId = ?1");
            query.setParameter(1, id);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
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
