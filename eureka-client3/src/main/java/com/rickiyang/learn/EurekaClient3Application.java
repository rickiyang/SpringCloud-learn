package com.rickiyang.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient3Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient3Application.class, args);
    }

}
