package com.rickiyang.learn.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    /**
     * 支持服务降级
     * 自定义降级处理的超时时间，并发数
     * 自定义执行该任务的线程池参数
     * 自定义执行熔断逻辑的异常
     * @param name
     * @return
     */
    @HystrixCommand(
        fallbackMethod = "hiError",
        commandProperties={
            // 降级处理超时时间设置
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            // 任意时间点允许的最高并发数。超过该设置值后，拒绝执行请求。
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "1000"),
        },
        // 配置执行的线程池
        threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "20"),
            @HystrixProperty(name = "maxQueueSize", value = "-1"),
        },
        // 该异常不执行熔断，去执行该异常抛出的自己逻辑
        ignoreExceptions = {NoSuchMethodException.class}
    )
    public String hello(String name) {
        return restTemplate.getForEntity("http://eureka-client/hello/" + name, String.class).getBody();
    }

    public String add(Person person) {
        return restTemplate.postForEntity("http://eureka-client/add",person,String.class).getBody();
    }

    public String getPerson(Integer id) {
        return restTemplate.getForEntity("http://eureka-client/getPerson/" + id, String.class).getBody();
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
