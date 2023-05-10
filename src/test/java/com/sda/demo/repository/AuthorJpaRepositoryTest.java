package com.sda.demo.repository;

import com.sda.demo.model.Author;
import com.sda.demo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorJpaRepositoryTest {

    @Autowired
    private AuthorJpaRepository repository;

    @Test
    void shouldSaveAuthor() {
        Author author = new Author("Frank Herbert", Set.of(new Book("Dune")));

        Author save = repository.save(author);
        assertNotNull(save);
    }
}