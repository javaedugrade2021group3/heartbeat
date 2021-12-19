package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.CategoryEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAO implements DAOInterface <CategoryEntity> {


    @Override
    public void deleteEntryById(short id) {
    }

    @Override
    public List<CategoryEntity> searchById(short id) {
        return null;
    }

    @Override
    public ObservableList<CategoryEntity> getAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CategoryEntity> categoryEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CategoryEntity> query = entityManager.createQuery("from CategoryEntity", CategoryEntity.class);
            categoryEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return FXCollections.observableArrayList(categoryEntityList);
    }
}
