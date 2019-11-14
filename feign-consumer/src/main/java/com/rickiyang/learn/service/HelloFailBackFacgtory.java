package com.rickiyang.learn.service;

import com.rickiyang.learn.entity.Person;
import feign.hystrix.FallbackFactory;

public class HelloFailBackFacgtory implements FallbackFactory<HelloRemote> {

    @Override
    public HelloRemote create(Throwable throwable) {
        return new HelloRemote() {
            @Override
            public String hello(String name) {
                return "fail reason is : " + throwable.getMessage();
            }

            @Override
            public String addPerson(Person person) {
                return "fail reason is : " + throwable.getMessage();

            }

            @Override
            public String getPerson(Integer id) {
                return "fail reason is : " + throwable.getMessage();

            }
        };
    }
}
