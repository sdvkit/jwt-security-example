package com.sdv.kit.RestSecurityTest.model;

public class Person {

    private String login;
    private String password;

    public Person(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Person() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
