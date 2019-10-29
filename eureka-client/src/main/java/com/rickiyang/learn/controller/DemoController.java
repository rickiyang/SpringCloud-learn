package com.rickiyang.learn.controller;

import com.alibaba.fastjson.JSON;
import com.rickiyang.learn.entity.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @author rickiyang
 * @date 2019-10-08
 * @Desc TODO
 */
@RestController
public class DemoController {


    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "hello " + name;
    }


    @PostMapping(name ="add",produces = "application/json; charset=UTF-8")
    public String addPerson(Person person){
        return JSON.toJSONString(person);
    }

    @GetMapping(name ="getPerson/{id}")
    public String getPerson(@PathVariable("id") Integer id){
        return String.join("-",id.toString(),"-name:xiaoming","age:23","sex:女");
    }

}
