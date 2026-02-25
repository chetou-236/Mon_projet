package com.groupeisi.company.repository;

import com.groupeisi.company.config.HibernateUtil;
import com.groupeisi.company.entities.AccountEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountRepository extends Repository<AccountEntity> implements IAccountRepository {

    @Override
    public AccountEntity login(String email, String password) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            AccountEntity account = session.createQuery(
                            "SELECT a FROM AccountEntity a WHERE a.email = :email AND a.password = :password",
                            AccountEntity.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();

            transaction.commit();
            return account;

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }
}
