package com.groupeisi.company.repository;

import com.groupeisi.company.entities.AccountEntity;

import java.util.List;
import javax.servlet.http.HttpSession;

public class AccountRepository implements IAccountRepository, Repository<AccountEntity> {

    @Override
    public AccountEntity login(String username, String password) {

        //return (AccountEntity) session.createQuery("SELECT account FROM AccountEntity account WHERE account.username="+username+" AND account.password="+password).getSingleResult();
        return (AccountEntity) session.createQuery("SELECT account FROM AccountEntity account WHERE account.username=:email AND account.password=:pwd")
                .setParameter("email", username)
                .setParameter("pwd", password)
                .getSingleResult();
    }

    @Override
    public boolean save(AccountEntity accountEntity) {
        return false;
    }

    @Override
    public boolean delete(long id, AccountEntity accountEntity) {
        return false;
    }

    @Override
    public boolean create(AccountEntity accountEntity) {
        return false;
    }

    @Override
    public boolean delete(String id, AccountEntity accountEntity) {
        return false;
    }

    @Override
    public boolean update(AccountEntity accountEntity) {
        return false;
    }

    @Override
    public AccountEntity find(String id, AccountEntity accountEntity) {
        return null;
    }

    @Override
    public List<AccountEntity> all(AccountEntity accountEntity) {
        return List.of();
    }

    @Override
    public List<AccountEntity> list(AccountEntity accountEntity) {
        return List.of();
    }

    @Override
    public AccountEntity get(long id, AccountEntity accountEntity) {
        return null;
    }

    @Override
    public List<AccountEntity> listpaginate(AccountEntity accountEntity, int page, int pageSize) {
        return List.of();
    }
}

