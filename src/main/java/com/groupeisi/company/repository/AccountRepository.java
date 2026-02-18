package com.groupeisi.company.repository;


import com.groupeisi.company.entities.AccountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;


public class AccountRepository extends Repository<AccountEntity> implements IAccountRepository{




    private SessionFactory sessionFactory;

    @Override
    public AccountEntity login(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "SELECT account FROM AccountEntity account " + "WHERE account.username=:email AND account.password=:pwd",
                AccountEntity.class)
                .setParameter("email", username)
                .setParameter("pwd", password)
                .getSingleResult();
    }
}

