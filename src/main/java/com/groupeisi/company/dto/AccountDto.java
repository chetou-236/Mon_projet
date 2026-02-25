package com.groupeisi.company.dto;

public class AccountDto {

    private String email;
    private String password;
    private String username;

    public AccountDto() {
    }

    public AccountDto(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
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

    @Override
    public String toString() {
        return "AccountDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
