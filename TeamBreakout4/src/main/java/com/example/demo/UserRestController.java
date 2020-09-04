package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController

public class UserRestController{

    @Autowired
    private UserService service;

    @GetMapping(value="/AllUsers", produces={"application/json","application/xml"})
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(value="/getUserByUserName/{username}", produces={"application/json","application/xml"})
    public List<User> getUserByUserName(@PathVariable String username) {
        return service.getUserByUserName(username);
    }

    @GetMapping(value="/getUserByFullName/{fullname}", produces={"application/json","application/xml"})
    public List<User> getUserByFullName(@PathVariable String fullname) {
        return service.getUserByUserName(fullname);
    }

    @PostMapping(value="/insertNewUser",consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<User> addUser (@RequestBody User user) {
        System.out.println("Adding " + user);
        service.insertNewUser(user);
        URI uri = URI.create("/user/" + user.getUsername());
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value="/updateUserByUsername/{username}", consumes={"application/json","application/xml"})
    public ResponseEntity modifyUser(@PathVariable String username, @RequestBody User user) {
        if (service.getUserByUserName(username) == null)
            return ResponseEntity.notFound().build();
        else {
            System.out.println("Updating details of " + username);
            service.updateUserByUserName(user);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/deleteUserByUserName/{username}")
    public ResponseEntity deleteUser(@PathVariable String username) {
        if (service.getUserByUserName(username) == null)
            return ResponseEntity.notFound().build();
        else {
            System.out.println("Deleting details of " + username);
            service.deleteUserByUserName(username);
            return ResponseEntity.ok().build();
        }
    }

}

