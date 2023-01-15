package com.driver.models;

import javax.persistence.*;

public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dimensions;
    private String description;

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn
    private int blog;

    public Image(String dimensions, String description, Blog blog) {
        this.dimensions = dimensions;
        this.description = description;
        this.blog = blog.getId();
    }
    public Image(){


    }
}