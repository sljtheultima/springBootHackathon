package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User{

    @Id
    private ObjectId userId;

    private String username;
    private String password;
    private String fullname;

//    public User(ObjectId userId, String username, String password, String fullname){
//        this.userId = userId;
//        this.username = username;
//        this.password = password;
//        this. fullname = fullname;
//    }

    public User(String username, String password, String fullname){
        this.username = username;
        this.password = password;
        this. fullname = fullname;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname(){
        return fullname;
    }

    @Override
    public String toString() {
        return String.format("User [userId=%s, username=%s, full name=%s, password=%s]", userId, username, fullname, password);
    }
}