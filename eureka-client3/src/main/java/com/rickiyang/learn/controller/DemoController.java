package com.rickiyang.learn.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author rickiyang
 * @date 2019-10-08
 * @Desc TODO
 */
@RestController
public class DemoController {


    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "hello " + name;
    }
}
