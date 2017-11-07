package com.example.sony.training;

/**
 * Created by Administrator on 11/05/17.
 */

public class User {
    private String name;
    private String hello;

    public User() {
    }

    public User(String name, String hello) {
        this.name = name;
        this.hello = hello;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
