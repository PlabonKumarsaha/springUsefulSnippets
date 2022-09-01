package com.pks.graphql.service;

import com.pks.graphql.entity.Book;
import com.pks.graphql.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepo bookRepo;
    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book getOne(Long id) {
        return bookRepo.findById(id).orElse(new Book());
    }
}
