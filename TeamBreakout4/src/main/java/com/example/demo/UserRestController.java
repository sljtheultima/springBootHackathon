package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserRestController{

    @Autowired
    private UserService service;

    // Get all users
    @GetMapping(value="/AllUsers", produces={"application/json","application/xml"})
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // Get user by username
    @GetMapping(value="/getUserByUserName/{username}", produces={"application/json","application/xml"})
    public List<User> getUserByUserName(@PathVariable String username) {
        return service.getUserByUserName(username);
    }

    // Get user by fullname
    @GetMapping(value="/getUserByFullName/{fullname}", produces={"application/json","application/xml"})
    public List<User> getUserByFullName(@PathVariable String fullname) { return service.getUserByFullName(fullname); }

    // Insert new user
    @PostMapping(value="/insertNewUser",consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<User> addUser (@RequestBody User user) {
        System.out.println("Adding " + user);
        service.insertNewUser(user);
        URI uri = URI.create("/user/" + user.getUsername());
        return ResponseEntity.created(uri).body(user);
    }

    // Update current user by username
    @PutMapping(value="/updateUserByUsername/{username}", consumes={"application/json","application/xml"})
    public ResponseEntity modifyUser(@PathVariable String username, @RequestBody User user) {
        if (service.getUserByUserName(username) == null)
            return ResponseEntity.notFound().build();
        else {
            System.out.println("Updating details of " + username);

            List<User> listFromDb = service.getUserByUserName(username);
            User fromUserList = listFromDb.get(0);
            // Update user from user getter/setter
            fromUserList.setUsername(user.getUsername());
            fromUserList.setPassword(user.getPassword());
            fromUserList.setFullname(user.getFullname());

            service.updateUserByUserName(fromUserList);

            return ResponseEntity.ok().build();
        }
    }

    // Delete user by username
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

