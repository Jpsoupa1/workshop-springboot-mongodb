package com.soupa.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soupa.workshop.model.User;
import com.soupa.workshop.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
       // System.out.println(repo.);
        return repo.findAll();
    }
}
