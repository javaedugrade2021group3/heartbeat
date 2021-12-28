package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.ActorEntity;
import com.edugrade.heartbeat.Model.CustomerEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ActorDAO implements DAOInterface<ActorEntity>{
    @Override
    public void deleteEntryById(short id) {

    }

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
    public void updateActor(short id, String firstName, String lastName) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        Date date = new Date();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            ActorEntity actor = entityManager.find(ActorEntity.class, id);
            entityManager.detach(actor);
            actor.setFirstName(firstName);
            actor.setLastName(lastName);
            actor.setLastUpdate(new Timestamp(date.getTime()));
            entityManager.merge(actor);
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


    public void deleteById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        ActorEntity actor = entityManager.find(ActorEntity.class, id);
        if (actor != null) {
            try {
                entityManager.getTransaction().begin();
                actor.getFilms().forEach(movie -> {
                    movie.getActors().remove(actor);
                });
                entityManager.remove(actor);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public Optional<ActorEntity> save(ActorEntity actor) {
        Date date = new Date();
        actor.setLastUpdate(new Timestamp(date.getTime()));
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(actor);
            entityManager.getTransaction().commit();
            return Optional.of(actor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

