package com.rickiyang.learn.service;

import com.rickiyang.learn.entity.Person;

public class HelloFailBackService implements HelloRemote {

    @Override
    public String hello(String name) {
        return "";
    }

    @Override
    public String addPerson(Person person) {
        return null;
    }

    @Override
    public String getPerson(Integer id) {
        return null;
    }
}
