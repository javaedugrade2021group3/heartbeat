package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.PaymentEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PaymentDAO implements DAOInterface<PaymentEntity>{
    //test

    @Override
    public List<PaymentEntity> searchById(short id) {
        return null;
    }

    @Override
    public ObservableList<PaymentEntity> getAll() {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<PaymentEntity> paymentEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<PaymentEntity> query = entityManager.createQuery("from PaymentEntity ",PaymentEntity.class);
            paymentEntityList= query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(paymentEntityList);
    }
}
