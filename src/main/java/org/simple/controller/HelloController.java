package org.simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello World! 第6次修改:移除了docker.sock访问权限修改，将在服务器启动时自动修改，不放置到jenkins中，添加了webhook,修复了pipeline语法问题";
    }
}
