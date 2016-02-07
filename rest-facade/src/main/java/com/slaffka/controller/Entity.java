package com.slaffka.controller;

/**
 * Created by slaffka85 on 07.02.2016.
 */
public class Entity {
    private Long id;

    private String name;

    public Entity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
