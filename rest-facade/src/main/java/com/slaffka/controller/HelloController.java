package com.slaffka.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping("/home")
    public String home() {
        return "Hello world from Spring Boot";
    }

    @RequestMapping("/home1")
    public String home1() {
        return "Hello world from Spring Boot";
    }

    @RequestMapping("/say/{what}")
    public String say(@PathVariable String what) {
        return what;
    }

    public Entity doSomething() {
        Entity entity = new Entity(new Long(1), "entity");
        return entity;
    }
}
