package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        //Testing Feature 2
        UserService service = ctx.getBean(UserService.class);
        service.getAllUsers();

        User newUser = new User("test", "test", "testing");
        service.insertNewUser(newUser);

        service.getAllUsers();

        service.getUserByFullName("Goh Chong Rui");

        List<User> listFromDb = service.getUserByUserName("hal");
        User fromUserList = listFromDb.get(0);
        // Update user from user getter/setter
        fromUserList.setFullname("Hal Sim Li Jin");
        service.updateUserByUserName(fromUserList);

        // delete
        service.deleteUserByUserName("test");


    }

    /*
    //Mock Implementation for Feature 1
    @Bean
    @Scope("application")
    public Map<Integer, User> userlist() {
        Map<Integer, User> users = new HashMap<>();
        users.put(0, new User(0,"hal", "hjk3n3kf","Sim Li Jin"));
        users.put(1, new User(1,"wongxx", "012udker!","Wong Xin Xian"));
        users.put(2, new User(2,"chongr", "jnjn3/@34","Goh Chong Rui"));
        return users;
    }*/

}
