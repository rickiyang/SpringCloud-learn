package com.rickiyang.learn.controller;

import com.rickiyang.learn.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: rickiyang
 * @date: 2019/10/5
 * @description:
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloRemote helloRemote;
    @Autowired
    private RestTemplate restTemplate;

    private final String APP_NAME = "eureka-client";

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return helloRemote.hello(name);
    }

    @GetMapping("/hello1/{name}")
    public String hello1(@PathVariable("name") String name){
        String url = "http://"+ APP_NAME +"/hello/"+name;
        return restTemplate.getForObject(url,String.class);
    }

}