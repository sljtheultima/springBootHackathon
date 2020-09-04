package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class seedDb {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void init(){
        repository.deleteAll();
        repository.save(new User("hal", "hjk3n3kf","Sim Li Jin"));
        repository.save(new User("wongxx", "012udker!","Wong Xin Xian"));
        repository.save(new User("chongr", "jnjn3/@34","Goh Chong Rui"));

    }

}
