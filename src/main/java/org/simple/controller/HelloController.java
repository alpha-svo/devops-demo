package org.simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello World! 第5次修改:添加了docker.sock访问权限修改问题，添加了webhook,修复了pipeline语法问题";
    }
}
