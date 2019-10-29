package com.rickiyang.learn.service;

import com.rickiyang.learn.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author rickiyang
 * @date 2019-10-08
 * @Desc TODO
 */
@Service
public class DemoService {

    @Autowired
    RestTemplate restTemplate;

    public String hello(String name) {
        return restTemplate.getForEntity("http://eureka-client/hello/" + name, String.class).getBody();
    }

    public String add(Person person) {
        return restTemplate.postForEntity("http://eureka-client/add",person,String.class).getBody();
    }

    public String getPerson(Integer id) {
        return restTemplate.getForEntity("http://eureka-client/getPerson/" + id, String.class).getBody();
    }
}
