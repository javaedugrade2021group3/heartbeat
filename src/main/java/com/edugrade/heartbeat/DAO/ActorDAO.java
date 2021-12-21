package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.ActorEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ActorDAO implements DAOInterface<ActorEntity>{
    @Override
    public List<ActorEntity> searchById(short id) {
        return null;
    }

    @Override
    public ObservableList<ActorEntity> getAll() {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<ActorEntity> actorEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<ActorEntity> query = entityManager.createQuery("from ActorEntity", ActorEntity.class);
            actorEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(actorEntityList);
    }
}
