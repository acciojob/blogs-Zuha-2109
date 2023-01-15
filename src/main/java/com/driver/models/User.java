package com.driver.models;



import javax.persistence.*;
import java.util.List;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String username;
   private String password;

    private String fname;
    private String lname;

    public User(){

    }

    public User(String username, String password, String fname, String lname){
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Blog> blogList;

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList){
        this.blogList = blogList;
    }
}