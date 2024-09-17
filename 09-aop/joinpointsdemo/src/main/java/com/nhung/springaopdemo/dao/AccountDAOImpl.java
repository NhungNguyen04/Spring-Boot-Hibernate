package com.nhung.springaopdemo.dao;


import com.nhung.springaopdemo.Entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void sendToCloud() {
        System.out.println("Sending to cloud");
    }

    @Override
    public List<Account> findAccount() {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account(1, "Nhung"));
        accounts.add(new Account(2, "Hung"));
        accounts.add(new Account(3, "Trang"));

        return accounts;
    }
}
