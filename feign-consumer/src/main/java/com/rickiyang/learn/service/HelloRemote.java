package com.rickiyang.learn.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: rickiyang
 * @date: 2019/10/5
 * @description:
 */
@FeignClient(name= "eureka-client")
public interface HelloRemote {


    @RequestMapping(value = "/hello/{name}")
    String hello(@PathVariable(value = "name") String name);
}