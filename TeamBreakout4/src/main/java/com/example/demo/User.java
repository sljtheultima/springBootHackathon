package com.example.demo;

public class User{

    private int id;
    private String username;
    private String password;
    private String fullname;

    public User(int id, String username, String password, String fullname){
        this.id = id;
        this.username = username;
        this.password = password;
        this. fullname = fullname;
    }

    public String getId(){ return id;}

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname(){
        return fullname;
    }
}