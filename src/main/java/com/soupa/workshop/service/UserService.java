package com.soupa.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soupa.workshop.dto.UserDTO;
import com.soupa.workshop.model.User;
import com.soupa.workshop.repository.UserRepository;
import com.soupa.workshop.service.exception.ObjectNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
       // System.out.println(repo.);
        return repo.findAll();
    }
    
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado."));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }
    
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(),objDto.getEmail());

    }
}
