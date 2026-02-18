package com.groupeisi.company.repository;

import com.groupeisi.company.config.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Transaction;

import java.util.List;

public class Repository <T> implements IRepository <T>{
    protected Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    private static Logger logger= LoggerFactory.getLogger(HibernateUtil.class);

    @Override
    public boolean create(T t) {
        try {
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.error("error, ", e);
            return false;
        }
    }

    @Override
    public boolean delete(String id, T t) {
        try {
            transaction = session.beginTransaction();
            session.delete(session.get(t.getClass(), id));
            transaction.commit();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override
    public boolean update(T t) {
        try {
            transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override
    public T find(String id, T t) {
        return (T) session.get(t.getClass(), id);
    }

    @Override
    public List<T> all(T t) {
        //return session.createQuery("SELECT t FROM " + T + " " + t).getResultList();
        CriteriaQuery<T> cq = (CriteriaQuery<T>) getCriteriaBuilder().createQuery(t.getClass());
        Root<T> root = (Root<T>) cq.from(t.getClass());
        cq.select(root);

        return session.createQuery(cq).getResultList();
    }

    private CriteriaBuilder getCriteriaBuilder() {
        return session.getCriteriaBuilder();
    }


}
