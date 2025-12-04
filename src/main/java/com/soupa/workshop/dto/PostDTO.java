package com.soupa.workshop.dto;

import com.soupa.workshop.model.Post;

public class PostDTO {
    private String id;
    
    public PostDTO() {
    }
    
    public PostDTO(Post obj) {
        this.id = obj.getId();
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

}
