package com.nhung.springaopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class AccountDAOImpl implements AccountDAO {

    String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addAccount() {
        System.out.println("Adding account named" + name);
    }

    @Override
    public void sendToCloud() {
        System.out.println("Sending to cloud");
    }
}
