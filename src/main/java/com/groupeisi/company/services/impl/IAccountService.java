package com.groupeisi.company.services.impl;

import com.groupeisi.company.dto.AccountDto;

import java.util.List;

public interface IAccountService {
    AccountDto getAccount(String username);
    AccountDto createAccount(AccountDto accountDto);
    AccountDto updateAccount(AccountDto accountDto);
    boolean deleteAccount(String username);
    AccountDto login(String username, String password);
    List<AccountDto> getAllAccounts();

}
