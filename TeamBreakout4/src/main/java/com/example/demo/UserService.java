package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    public Object insertNewUser(User u){
        return repository.save(u);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public List<User> getUserByUserName(String username){ return repository.findUserByUsername(username); }

    public List<User> getUserByFullName(String fullName){
        return repository.findUserByFullName(fullName);
    }

    public Object updateUserByUserName(User u){
        return repository.save(u);
    }

    public void deleteUserByUserName(String username){
        repository.deleteUserByUsername(username);
    }

}
