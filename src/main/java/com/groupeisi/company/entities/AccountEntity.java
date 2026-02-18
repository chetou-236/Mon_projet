package com.groupeisi.company.entities;

import javax.persistence.*;

import java.io.Serializable;



@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {
    /**
     * identifiant de l utilisateur
     */
    @Id
    @Column(length = 200)
    private String username;

    /**
     * Mot de passe de l utilisateur
     */
    @Column(length = 210, nullable = false)
    private String password;

    public AccountEntity() {
    }

    public AccountEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
