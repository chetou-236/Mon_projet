package com.groupeisi.company.services.impl;

import com.groupeisi.company.dto.AccountDto;

import java.util.List;

public interface IAccountService {
    AccountDto createAccount(AccountDto dto);
    AccountDto login(String email, String password);
    List<AccountDto> getAllAccounts();
    AccountDto getAccount(String username);
    AccountDto updateAccount(AccountDto dto);

}
