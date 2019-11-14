package com.rickiyang.learn.service;

import com.rickiyang.learn.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: rickiyang
 * @date: 2019/10/5
 * @description:
 */
//@FeignClient(name= "eureka-client",fallback = HelloFailBackService.class)
@FeignClient(name= "eureka-client",fallback = HelloFailBackFacgtory.class)
public interface HelloRemote {

    @RequestMapping(value = "/hello/{name}")
    String hello(@PathVariable(value = "name") String name);


    @PostMapping(value ="/add",produces = "application/json; charset=UTF-8")
    String addPerson(@RequestBody Person person);

    @GetMapping("/getPerson/{id}")
    String getPerson(@PathVariable("id") Integer id);

}