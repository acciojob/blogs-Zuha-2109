package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
        List<Blog> blogList = new ArrayList<>();

        return blogRepository1.saveAll(blogList);

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {


        //create a blog at the current time
        Blog blog = new Blog(title, content);
        User user = userRepository1.findById(userId).get();
        List<Blog> listofblogs = user.getBlogList();
        listofblogs.add(blog);
        user.setBlogList(listofblogs);

        blogRepository1.save(blog);
        userRepository1.save(user);

        //updating the blog details

        //Updating the userInformation and changing its blogs

    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository1.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it

        Image image=new Image(description,dimensions);
        Blog blog=blogRepository1.findById(blogId).get();
        List<Image> AllImages=blog.getImageList();
        AllImages.add(image);
        blog.setImageList(AllImages);

        blogRepository1.save(blog);
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}
