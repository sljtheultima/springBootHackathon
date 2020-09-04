package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    public void getAllUsers() {
        displayUser("testing", repository.findAll());
    }

    public void insertNewUser(User u){
        repository.save(u);
    }

    public User getSpecificUserByUserName(String username){
        return repository.findUserByUsername(username);
    }

    private void displayUser(String message, Iterable<User> employees) {
        System.out.printf("\n%s\n", message);
        for (User emp : employees) {
            System.out.println(emp);
        }
    }
}
