package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.LanguageEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LanguageDAO implements DAOInterface <LanguageEntity>{


    @Override
    public void deleteEntryById(short id) {

    }

    @Override
    public List<LanguageEntity> searchById(short id) {return null; }

    @Override
    public ObservableList<LanguageEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<LanguageEntity> languageEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<LanguageEntity> query = entityManager.createQuery("from LanguageEntity ",LanguageEntity.class);
            languageEntityList = query.getResultList();
            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(languageEntityList);
    }
}
