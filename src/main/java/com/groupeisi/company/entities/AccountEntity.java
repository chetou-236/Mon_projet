package com.groupeisi.company.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {

    @Id
    @Column(length = 200)
    private String username;

    @Column(length = 210, nullable = false)
    private String password;

    @Column(length = 200, unique = true)
    private String email;

    public AccountEntity() {
    }

    public AccountEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters & Setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
