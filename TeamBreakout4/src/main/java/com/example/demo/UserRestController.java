package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController

public class UserRestController{

    @Autowired
    private Map<Integer, User> userlist;

    @Autowired
    private Userservice service;

    @GetMapping(value="/items", produces={"application/json","application/xml"})
    public List<Item> getAllUsers() {
        return service.getAllUsers()
                .keySet()
                .stream()
                .map(id -> userlist.get(id))
                .collect(Collectors.toList());
    }

}