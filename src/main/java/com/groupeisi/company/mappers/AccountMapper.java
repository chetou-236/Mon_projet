package com.groupeisi.company.mappers;

import com.groupeisi.company.dto.AccountDto;
import com.groupeisi.company.entities.AccountEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {
    /**
     * Cette methode permet de cnvertir une methode en Entity en Dto
     *
     * @param accountEntity : l'Entite a convertir
     * @return : le Dto obtenu apres convertion
     */
    public AccountDto toAccountDto(AccountEntity accountEntity) {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername(accountEntity.getUsername());
        accountDto.setPassword(accountEntity.getPassword());
        return accountDto;
    }

    /**
     * Cette methode permet de convertir un Dto en Entity
     *
     * @param accountDto : le Dto a convertir
     * @return : l'Entity obtenu apres convertion
     */
    public AccountEntity toAccountEntity(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUsername(accountDto.getUsername());
        accountEntity.setPassword(accountDto.getPassword());
        return accountEntity;
    }

    /**
     * Cette methode permet de convertir une Liste d'Entity en une Liste des Dto
     *
     * @param accountEntityList : La liste des Entite a convertir
     * @return : La liste des Dto obtenu apres convertion
     */
    public List<AccountDto> toListAccountDto(List<AccountEntity> accountEntityList) {
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountEntityList.forEach(accountEntity -> {
            accountDtoList.add(toAccountDto(accountEntity));
        });
        return accountDtoList;
    }

    /**
     * Cette methode permet de convertir une List des Dto en une liste d'Entity
     * En utilisant l'appel par reference avec map
     * @param accountDtoList : La liste des Dto a convertir
     * @return : La liste des Entity obtenue apres convertion
     */
    public List<AccountEntity> toListAccountEntity(List<AccountDto> accountDtoList) {
        return accountDtoList.stream()
                .map(this::toAccountEntity)
                .collect(Collectors.toList());
    }

}
