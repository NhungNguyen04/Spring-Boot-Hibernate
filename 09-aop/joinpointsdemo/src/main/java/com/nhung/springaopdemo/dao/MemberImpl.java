package com.nhung.springaopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class MemberImpl implements Member{

    Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void addMember() {
        System.out.println("Adding member account with id " + id);
    }

    @Override
    public void sendApi() {
        System.out.println("Sending api");
    }
}
