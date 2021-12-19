package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.CountryEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CountryDAO implements DAOInterface <CountryEntity> {


    @Override
    public void deleteEntryById(short id) {

    }

    @Override
    public List<CountryEntity> searchById(short id) { return null; }

    @Override
    public ObservableList<CountryEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CountryEntity> countryEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CountryEntity> query = entityManager.createQuery("from CountryEntity", CountryEntity.class);
            countryEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return FXCollections.observableArrayList(countryEntityList);
    }
}
