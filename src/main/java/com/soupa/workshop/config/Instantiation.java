package com.soupa.workshop.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.soupa.workshop.dto.AuthorDTO;
import com.soupa.workshop.dto.PostDTO;
import com.soupa.workshop.model.Comment;
import com.soupa.workshop.model.Post;
import com.soupa.workshop.model.User;
import com.soupa.workshop.repository.CommentRepository;
import com.soupa.workshop.repository.PostRepository;
import com.soupa.workshop.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{
    
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();
        userRepository.deleteAll();
        commentRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Partiu viagem", "Vou viajar para Sao Paulo. Abracos!!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/07/2018"),"Bom dia", "Acordei feliz hoje...", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);

        Comment comment1 = new Comment("Vou viajar tambem", sdf2.parse("21/03/2018 13:05:00"), new AuthorDTO(alex),new PostDTO(post1));
        Comment comment2 = new Comment("Aproveite", sdf2.parse("22/03/2018 10:40:00"),new AuthorDTO(bob),new PostDTO(post1));

        commentRepository.saveAll(Arrays.asList(comment1, comment2));
        
        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        postRepository.save(post1);
        
    }    
}
