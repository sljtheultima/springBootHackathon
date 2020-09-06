package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController


public class UserRestController{

    @Autowired
    private UserService service;

   /* //For mock implementation for Feature 1
    @Autowired
    private Map<Integer, User> userlist;*/

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

  /*  //Mock Implementation on userlist for Feature 1

    @GetMapping(value="/AllUsers", produces={"application/json","application/xml"})
    public ResponseEntity<Collection<User>> getAllUsers() {
        Collection<User> result = userlist.values();
        return ResponseEntity.ok().body(result);
    }


    @PostMapping(value="/insertNewUser",consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<User> addUser (@RequestBody User user) {
        System.out.println("Adding " + user);
        userlist.put(user.getId(), user);
        URI uri = URI.create("/user/" + user.getUsername());
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value="/updateUser/{id}", consumes={"application/json","application/xml"})
    public ResponseEntity modifyUser(@PathVariable int id, @RequestBody User user) {
        if (!userlist.containsKey(id))
            return ResponseEntity.notFound().build();
        else {
            System.out.println("Updating details of user id " + id);
            userlist.put(id, user);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        if (!userlist.containsKey(id))
            return ResponseEntity.notFound().build();
        else {
            System.out.println("Deleting details of user id" + id);
            userlist.remove(id);
            return ResponseEntity.ok().build();
        }
    }*/


}

