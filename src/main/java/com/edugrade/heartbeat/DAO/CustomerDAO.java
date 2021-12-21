package com.edugrade.heartbeat.DAO;

import com.edugrade.heartbeat.Model.CustomerEntity;
import com.edugrade.heartbeat.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

public class CustomerDAO implements DAOInterface<CustomerEntity> {

    /**
     * This method is used to update a customer entity object, depending on its id.
     * 1The parameters come from the text fields during runtime.
     * */
    public void updateCustomer(short id, String firstName, String lastName, byte storeId, String email, short addressId, byte active) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        Date date = new Date();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            CustomerEntity customer = entityManager.find(CustomerEntity.class, id);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setStoreId(storeId);
            customer.setEmail(email);
            customer.setAddressId(addressId);
            customer.setActive(active);
            customer.setLastUpdate(new Timestamp(date.getTime()));
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

    /**
     * This method is used to add a new customer entity object to the database.
     * The parameters are filled in at the text fields during runtime.
     * */
    public void addNewCustomer(String firstName, String lastName, byte storeId, String email, short addressId, byte active) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        Date date = new Date();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            CustomerEntity customer = new CustomerEntity();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setStoreId(storeId);
            customer.setEmail(email);
            customer.setActive(active);
            customer.setAddressId(addressId);
            customer.setCreateDate(new Timestamp(date.getTime()));
            customer.setLastUpdate(new Timestamp(date.getTime()));

            entityManager.persist(customer);
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

    /**
     * This method is used to delete a customer entity object from the database, depending on the id.
     * The parameter is chosen during runtime, by clicking on an entity in the table.
     * */
    @Override
    public void deleteEntryById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM CustomerEntity c where c.customerId = ?1");
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

    /**
     * This method is used to search for a single customer in the database by using the customer's id.
     * The parameter is entered into a text field at runtime.
     * */
    @Override
    public ObservableList<CustomerEntity> searchById(short id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CustomerEntity> customerEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CustomerEntity> query = entityManager.createQuery("from CustomerEntity where customerId = ?1", CustomerEntity.class);
            query.setParameter(1, id);
            customerEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(customerEntityList);
    }

    /**
     * This method is used to search for all customers in the database.
     * */
    @Override
    public ObservableList<CustomerEntity> getAll() {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = null;
        List<CustomerEntity> customerEntityList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<CustomerEntity> query = entityManager.createQuery("from CustomerEntity", CustomerEntity.class);
            customerEntityList = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return FXCollections.observableArrayList(customerEntityList);
    }
}
