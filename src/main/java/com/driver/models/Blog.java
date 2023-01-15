package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.List;

public class Blog {

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private String title;
    private String content;

    public CreationTimestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(CreationTimestamp createdOn) {
        this.createdOn = createdOn;
    }

    private CreationTimestamp createdOn;

    public Blog( String title, String content) {
        this.title = title;
        this.content = content;
    }
    public Blog (){

    }

    @ManyToOne
    @JoinColumn

    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}