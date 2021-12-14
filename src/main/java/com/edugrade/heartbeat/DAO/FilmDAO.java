package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.FilmEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class FilmDAO implements DAOInterface<FilmEntity> {


        @Override
        public ObservableList<FilmEntity> getAll() {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            EntityTransaction transaction = null;
            List<FilmEntity> filmEntityList = null;

            try {
                transaction = entityManager.getTransaction();
                transaction.begin();
                TypedQuery<FilmEntity> query = entityManager.createQuery("from FilmEntity", FilmEntity.class);
                filmEntityList = query.getResultList();
                transaction.commit();

            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                entityManager.close();
            }

            return FXCollections.observableArrayList(filmEntityList);
        }
}

