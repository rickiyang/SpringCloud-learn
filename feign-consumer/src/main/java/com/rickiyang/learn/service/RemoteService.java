package com.rickiyang.learn.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: rickiyang
 * @date: 2019/10/5
 * @description:
 */
@Service
public class RemoteService {

    /**
     * 注入 RestTemplate
     * 并用 @LoadBalanced 注解，用负载均衡策略请求服务提供者
     * 这是 Spring Ribbon 提供的能力
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
