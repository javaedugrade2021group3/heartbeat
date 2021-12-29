package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.FilmEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;

public class FilmDAO implements DAOInterface<FilmEntity> {


    @Override
    public void deleteEntryById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM FilmEntity f where f.filmId = ?1");
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
    public List<FilmEntity> searchById(short id) {
        return null;
    }


    public void updateFilm(short id, String title, String description, Short releaseYear,byte languageId, byte rentalDuration, double rentalRate,short length, double replacementCost) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
       Date date = new Date();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            FilmEntity film = entityManager.find(FilmEntity.class, id);
            entityManager.detach(film);
            film.setTitle(title);
            film.setDescription(description);
            film.setReleaseYear(releaseYear);
            film.setLanguageId(languageId);
            film.setRentalDuration(rentalDuration);
            film.setRentalRate(rentalRate);
            film.setLength(length);
            film.setReplacementCost(replacementCost);
            film.setLastUpdate(new Timestamp(date.getTime()));
            entityManager.merge(film);
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


    public void addNewFilm(String title,String description,byte languageId, Short releaseYear, byte rentalDuration, double rentalRate,short length, double replacementCost) {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        Date date = new Date();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            FilmEntity film = new FilmEntity();
            film.setTitle(title);
            film.setDescription(description);
            film.setLanguageId(languageId);
            film.setReleaseYear(releaseYear);
            film.setRentalDuration(rentalDuration);
            film.setRentalRate(rentalRate);
            film.setLength(length);
            film.setReplacementCost(replacementCost);
            film.setLastUpdate(new Timestamp(date.getTime()));
            entityManager.persist(film);
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

