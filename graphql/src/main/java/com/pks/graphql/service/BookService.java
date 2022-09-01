package com.pks.graphql.service;

import com.pks.graphql.entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    List<Book> getAll();

    Book getOne(Long id);
}
