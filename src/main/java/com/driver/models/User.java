package com.driver.models;


import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;

import javax.persistence.*;
import java.util.List;


public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;
    private String email;

    private String Password;


    public User(){

    }
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        Password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return id;
    }

    @OneToMany(mappedBy ="user",cascade =CascadeType.ALL)
    private List<Blog> blogList;
}