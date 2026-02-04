package com.groupeisi.company.entities;

import javax.persistence.*;

import java.io.Serializable;



@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName", length = 250, nullable = false)
    private String firstName;
    @Column(name = "lastName", length = 200, nullable = false)
    private String lastName;
    @Column(name = "email", length = 250, nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    public AccountEntity(int id, String firstName, String lastName, String email, String password) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    public AccountEntity() {
        super();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
