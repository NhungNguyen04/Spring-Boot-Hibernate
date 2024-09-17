package com.nhung.springaopdemo.dao;

import com.nhung.springaopdemo.Entity.Account;

import java.util.List;

public interface AccountDAO {

    void sendToCloud();

    List<Account> findAccount();
}
