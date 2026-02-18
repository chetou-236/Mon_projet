package com.groupeisi.company.tests;

import com.groupeisi.company.entities.AccountEntity;
import com.groupeisi.company.repository.AccountRepository;
import com.groupeisi.company.repository.IAccountRepository;

public class TestsRepository {
    public static void main(String[] args) {
        IAccountRepository iAccountRepository = new AccountRepository();
        AccountEntity account = new AccountEntity();
        account.setUsername("user");
        account.setPassword("passer123");

        boolean response = iAccountRepository.create(account);
        System.out.println(response);

        try {
            AccountEntity accountResponse = iAccountRepository.login(account.getUsername(), account.getPassword());
            if (accountResponse != null) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

