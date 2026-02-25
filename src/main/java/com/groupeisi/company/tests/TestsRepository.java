package com.groupeisi.company.tests;

import com.groupeisi.company.entities.AccountEntity;
import com.groupeisi.company.repository.AccountRepository;
import com.groupeisi.company.repository.IAccountRepository;

public class TestsRepository {
    public static void main(String[] args) {
        IAccountRepository accountRepository = new AccountRepository();

        // Création du compte
        AccountEntity a = new AccountEntity("djamilla",
                "passer123",
                "djamilla@gmail.com");
        boolean created = accountRepository.create(a);
        System.out.println("Compte créé ? " + created);

        // Login
        try {
            AccountEntity accountResponse = accountRepository.login(a.getUsername(),
                    a.getPassword()); // ✅ utilisation de "a" ici
            if (accountResponse != null) {
                System.out.println("Login successful : " + accountResponse.getUsername());
            } else {
                System.out.println("Login Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}