package com.soupa.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soupa.workshop.model.Post;
import com.soupa.workshop.repository.PostRepository;
import com.soupa.workshop.service.exception.ObjectNotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
       // System.out.println(repo.);
        return repo.findAll();
    }   
    
    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado."));
    }
}
