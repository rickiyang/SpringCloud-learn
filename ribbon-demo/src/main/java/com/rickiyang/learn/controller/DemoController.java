package com.rickiyang.learn.controller;

import com.rickiyang.learn.service.DemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rickiyang
 * @date 2019-10-08
 * @Desc TODO
 */
@RestController
public class DemoController {

    @Resource
    private DemoService demoService;


    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return demoService.hello(name);
    }
}
