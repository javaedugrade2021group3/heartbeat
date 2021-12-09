package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.CustomerEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerDAO implements DAOInterface<CustomerEntity> {
    @Override
    public ObservableList<CustomerEntity> getAll() {

        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(CustomerEntity.class);
        query.from(CustomerEntity.class);

        //Root<CustomerEntity> root = query.from(CustomerEntity.class);
        //Predicate predicate = criteriaBuilder.equal(root.get("id"), 2);

        //List<CustomerEntity> customerList = session.createQuery(query.where(predicate)).getResultList();

        List<CustomerEntity> customerList = session.createQuery(query).getResultList();
        session.close();

        return FXCollections.observableArrayList(customerList);
    }
}
