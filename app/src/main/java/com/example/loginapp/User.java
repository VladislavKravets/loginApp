package com.example.loginapp;

import java.io.Serializable;

public class User implements Serializable {
    private final String login;
    private final String password;
    private final String full_name;
    private final String group;

    public User(String login, String password, String full_name, String group) {
        this.login = login;
        this.password = password;
        this.full_name = full_name;
        this.group = group;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() { return password; }

    public String getFull_name() {
        return full_name;
    }

    public String getGroup() {
        return group;
    }
}
