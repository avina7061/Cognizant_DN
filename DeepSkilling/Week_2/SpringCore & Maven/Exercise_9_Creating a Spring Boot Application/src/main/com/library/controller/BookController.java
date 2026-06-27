package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    // CREATE
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    // READ ALL
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}