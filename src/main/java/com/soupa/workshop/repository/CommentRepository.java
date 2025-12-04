package com.soupa.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.soupa.workshop.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String>{
    
}
