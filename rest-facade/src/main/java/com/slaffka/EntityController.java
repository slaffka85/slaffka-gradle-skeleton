package com.slaffka;

import com.slaffka.controller.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/entity")
public class EntityController {


    @RequestMapping("/home")
    @ResponseBody
    public String home() {

        return "Hello world from Spring Boot";
    }

    @RequestMapping("/home1")
    @ResponseBody
    public String home1() {
        return "Hello world from Spring Boot";
    }

    @RequestMapping("/say/{what}")
    @ResponseBody
    public String say(@PathVariable String what) {
        return what;
    }

    public Entity doSomething() {
        Entity entity = new Entity(new Long(1), "entity");
        return entity;
    }
}
