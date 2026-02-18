package com.groupeisi.company.repository;

import com.groupeisi.company.entities.AccountEntity;

public interface IAccountRepository extends IRepository<AccountEntity> {
    AccountEntity login(String username, String password);

}
