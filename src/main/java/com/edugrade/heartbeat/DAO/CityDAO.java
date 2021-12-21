package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.CityEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAO implements DAOInterface <CityEntity>{


    @Override
    public List<CityEntity> searchById(short id) {return null; }

    @Override
    public ObservableList<CityEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CityEntity> cityEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CityEntity> query = entityManager.createQuery("from CityEntity", CityEntity.class);
            cityEntityList = query.getResultList();
            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(cityEntityList);
    }
}
