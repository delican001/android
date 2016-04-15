package com.example.DBPersons;

import java.io.Serializable;

public class Persons implements Serializable{
    private long id;
    private String login;
    private String password;
    private String name;
    private String surname;

    public Persons (long id, String login, String password, String name,String surname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname=surname;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() { return name; }

    public String getSurname() {
        return surname;
    }
}
