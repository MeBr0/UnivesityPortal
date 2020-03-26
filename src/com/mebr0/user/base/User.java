package com.mebr0.user.base;

import com.mebr0.user.util.PasswordEncoder;

public abstract class User extends Person {

    private String id;
    private final String LOGIN;
    private String password;
    private String email;
    private String phoneNumber;

    public static final String DEFAULT_PASSWORD = "Kbtu111";

    {
        // Todo: login generator
        LOGIN = "";
        password = PasswordEncoder.encode(DEFAULT_PASSWORD);
    }

    public User(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public boolean checkCredentials(String login, String password) {
        String encodedPassword = PasswordEncoder.encode(password);
        return LOGIN.equalsIgnoreCase(login) && this.password.equals(encodedPassword);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalAccessException {
        if (this.id != null) {
            throw new IllegalAccessException("Id already initialized");
        }

        this.id = id;
    }

    public String getLogin() {
        return LOGIN;
    }

    public void setPassword(String password) {
        this.password = PasswordEncoder.encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
