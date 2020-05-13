package cn.stylefeng.guns.modular.demos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
@RestController
public class HelloController {
    @Value("${name}")
    private String name;

    @Value("${myurl}")
    private String myurl;


    @RequestMapping("/hello")
    public String hello() {
        return name+"Hello Spring Boot!"+myurl;
    }
}
