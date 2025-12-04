package com.soupa.workshop.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.soupa.workshop.dto.AuthorDTO;
import com.soupa.workshop.dto.PostDTO;

@Document(collection = "comments")
public class Comment {
    
    private String text;
    private Date date;
    private AuthorDTO author;
    private PostDTO post;
    
    
    public Comment() {
    }
    
    public Comment(String text, Date date, AuthorDTO author, PostDTO post) {
        this.text = text;
        this.date = date;
        this.author = author;
        this.post = post;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public AuthorDTO getAuthor() {
        return author;
    }
    
    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
    
    public PostDTO getPost() {
        return post;
    }
    
    public void setPost(PostDTO post) {
        this.post = post;
    }
    
    
}
