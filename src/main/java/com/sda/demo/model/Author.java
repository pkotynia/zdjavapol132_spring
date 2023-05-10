package com.sda.demo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
            joinColumns = {@JoinColumn(name = "a_id", referencedColumnName = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "b_id", referencedColumnName = "book_id")})
    private Set<Book> books = new HashSet<>();

//    @Transient - this annotation alow us to add fields that will be skipped by Hibernate
//    private Integer age;

    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Author() {
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (!Objects.equals(authorId, author.authorId)) return false;
        return Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        int result = authorId != null ? authorId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
