package com.slaffka.controller;

import com.slaffka.SpringFun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
//import static org.assertj.core.api.Assertions.*;

/**
 * Created by slaffka85 on 07.02.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringFun.class)
public class EntityControllerIntegrationTest {

    @Autowired
    EntityController entityController;

    @Test
    public void doSomething() {
        //HelloController entityController = new HelloController();
        String message = entityController.home();
        assertEquals("Hello world from Spring Boot", message);
        //assertThat(entity.getId())
    }
}
