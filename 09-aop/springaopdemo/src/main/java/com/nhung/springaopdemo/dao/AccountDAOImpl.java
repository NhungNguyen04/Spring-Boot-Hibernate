package com.nhung.springaopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class AccountDAOImpl implements AccountDAO {


    @Override
    public void addAccount() {
        System.out.println("Adding account");
    }
}
