package com.rickiyang.learn.controller;

import com.rickiyang.learn.entity.Person;
import com.rickiyang.learn.service.DemoService;
import org.springframework.web.bind.annotation.*;

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
    public String hello(@PathVariable("name") String name) {
        return demoService.hello(name);
    }

    @PostMapping(name = "add", produces = "application/json; charset=UTF-8")
    public String addPerson(Person person) {
        return demoService.add(person);
    }

    @GetMapping(name = "getPerson/{id}")
    public String getPerson(@PathVariable("id") Integer id) {
        return demoService.getPerson(id);
    }
}
