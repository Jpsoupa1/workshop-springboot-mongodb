package com.soupa.workshop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soupa.workshop.model.User;
import com.soupa.workshop.repository.UserRepository;
import com.soupa.workshop.service.UserService;


@RestController
@RequestMapping(value="/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repo;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/testar")
    public String testar() {
        try {
            repo.count(); // Isso OBRIGA o driver a acessar o Mongo
            return "Mongo OK";
        } catch (Exception e) {
            return "Mongo FALHOU: " + e.getMessage();
        }
    }
}

