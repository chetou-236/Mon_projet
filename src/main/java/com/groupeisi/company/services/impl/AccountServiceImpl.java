package com.groupeisi.company.services.impl;

import com.groupeisi.company.dto.AccountDto;
import com.groupeisi.company.entities.AccountEntity;
import com.groupeisi.company.repository.AccountRepository;
import com.groupeisi.company.repository.IAccountRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AccountServiceImpl implements IAccountService {

    private final IAccountRepository repository;

    public AccountServiceImpl() {
        this.repository = new AccountRepository();
    }

    @Override
    public AccountDto createAccount(AccountDto dto) {
        AccountEntity entity = new AccountEntity(dto.getUsername(), dto.getPassword());
        boolean created = repository.create(entity);
        return created ? dto : null;
    }

    @Override
    public AccountDto login(String email, String password) {
        // 🔹 récupère l'utilisateur depuis le repository
        AccountEntity account = repository.login(email, password);

        if (account != null) {
            // 🔹 retourne un DTO si trouvé
            return new AccountDto(account.getUsername(), account.getPassword(), account.getEmail());
        }
        return null; // si email/password incorrect
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return repository.all(AccountEntity.class)
                .stream()
                .map(a -> new AccountDto(a.getUsername(), a.getPassword(), a.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccount(String username) {
        AccountEntity account = repository.find(AccountEntity.class, username);
        if (account != null) {
            return new AccountDto(account.getUsername(), account.getPassword(), account.getEmail());
        }
        return null;
    }

    @Override
    public AccountDto updateAccount(AccountDto dto) {
        AccountEntity entity = repository.find(AccountEntity.class, dto.getUsername());
        if (entity != null) {
            entity.setPassword(dto.getPassword());
            entity.setEmail(dto.getUsername());
            boolean updated = repository.update(entity);
            return updated ? dto : null;
        }
        return null;
    }
}