package com.soupa.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.soupa.workshop.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    
}
