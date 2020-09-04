package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @Scope("application")
    public Map<Integer, User> userlist() {
        Map<Integer, User> users = new HashMap<>();
        users.put(0, new User("wongxx", "012udker!","Wong Xin Xian"));
        users.put(1, new User("hal", "hjk3n3kf","Sim Li Jin"));
        users.put(2, new User("chongr", "jnjn3/@34","Goh Chong Rui"));
        return users;
    }


}
