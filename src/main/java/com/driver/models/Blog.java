package com.driver.models;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;


    private Date publishDate;


    public Blog(){

    }

    public Blog(String title, String content, Date pubDate){
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getPublishDate() {
        return publishDate;
    }
    public void setPubDate(Date publishDate) {
        this.publishDate = publishDate;
    }


    @ManyToOne
    @JoinColumn
    public com.driver.models.User user;

    public User getUser(){
        return user;
    }


    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList;

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }


    public void setUser(com.driver.models.User user) {
        this.user = user;
    }
}