package com.groupeisi.company.services.impl;

import com.groupeisi.company.config.HibernateUtil;
import com.groupeisi.company.dto.AccountDto;
import com.groupeisi.company.entities.AccountEntity;
import com.groupeisi.company.mappers.AccountMapper;
import com.groupeisi.company.repository.AccountRepository;
import com.groupeisi.company.repository.IAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AccountServiceImpl  implements IAccountService {
    private IAccountRepository iAcountRepository = new AccountRepository();
    private AccountMapper accountMapper = new AccountMapper();
    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    @Override
    public AccountDto getAccount(String username) {
        try {
            AccountEntity accountEntity = iAcountRepository.find(username, new AccountEntity());

            if (accountEntity != null) {
                return accountMapper.toAccountDto(accountEntity);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        try {
            boolean result = iAcountRepository.create(accountMapper.toAccountEntity(accountDto));

            if (result) {
                return accountDto;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        try {
            boolean result = iAcountRepository.update(accountMapper.toAccountEntity(accountDto));

            if (result) {
                return accountDto;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteAccount(String username) {
        try {
            return iAcountRepository.delete(username, new AccountEntity());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public AccountDto login(String username, String password) {
        try {
            AccountEntity accountEntity = iAcountRepository.login(username, password);

            if (accountEntity != null) {
                return accountMapper.toAccountDto(accountEntity);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        try {
            List<AccountEntity> accountEntity = iAcountRepository.all(new AccountEntity());

            return accountMapper.toListAccountDto(accountEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
