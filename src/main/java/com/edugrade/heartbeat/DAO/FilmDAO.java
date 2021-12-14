package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.FilmEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class FilmDAO implements DAOInterface<FilmEntity> {
        @Override
        public ObservableList<FilmEntity> getAll() {

            Session session = HibernateUtil.getSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery query = criteriaBuilder.createQuery(FilmEntity.class);
            query.from(FilmEntity.class);

            //Root<FilmEntity> root = query.from(Film Entity.class);
            //Predicate predicate = criteriaBuilder.equal(root.get("id"), 2);

            //List<FilmEntity> filmList = session.createQuery(query.where(predicate)).getResultList();

            List<FilmEntity> filmList = session.createQuery(query).getResultList();
            session.close();

            return FXCollections.observableArrayList(filmList);
        }
}

