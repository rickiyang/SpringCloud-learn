package com.rickiyang.learn.service;

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
}
