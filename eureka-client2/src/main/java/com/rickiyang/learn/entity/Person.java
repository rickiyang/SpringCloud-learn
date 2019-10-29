package com.rickiyang.learn.entity;


import lombok.*;

/**
 * @author: rickiyang
 * @date: 2019/10/28
 * @description:
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private String name;
    private Integer age;
    private Integer sex;
    private String address;
}
