package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User{

    @Id
    private ObjectId userId;

    private String username;
    private String password;
    private String fullname;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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