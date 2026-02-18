package com.groupeisi.company.tests;


import com.groupeisi.company.dto.AccountDto;
import com.groupeisi.company.services.impl.AccountServiceImpl;
import com.groupeisi.company.services.impl.IAccountService;

public class TestsService {
    public static void main(String[] args) {
        IAccountService iAccountService = new AccountServiceImpl();
        AccountDto account = new AccountDto();
        account.setUsername("Mohamed");
        account.setPassword("passer123");

        //AccountDto response = iAccountService.createAccount(account);
        //System.out.println(response);

        try {
            AccountDto accountResponse = iAccountService.login(account.getUsername(), account.getPassword());
            if (accountResponse != null) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login Failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        iAccountService.getAllAccounts().forEach(System.out::println);
    }

}
