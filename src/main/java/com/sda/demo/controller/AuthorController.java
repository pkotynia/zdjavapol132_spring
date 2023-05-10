package com.sda.demo.controller;

import com.sda.demo.model.Author;
import com.sda.demo.repository.AuthorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    // Service should go here to implement full MVC
    @Autowired
    private AuthorJpaRepository repository;

    public AuthorController(AuthorJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author savedAuthor = repository.save(author);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAuthor.getAuthorId()).toUri();
        return ResponseEntity
                .created(location)
                .body(savedAuthor);
    }

}
