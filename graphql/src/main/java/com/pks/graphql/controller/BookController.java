package com.pks.graphql.controller;

import com.pks.graphql.entity.Book;
import com.pks.graphql.input.BookInput;
import com.pks.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    Book save(@Argument BookInput book) {
        Book book1 = new Book();
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        return bookService.createBook(book1);

    }

    @QueryMapping("allBooks")
    List<Book>getAll(){
        return bookService.getAll();
    }

    @QueryMapping("getBook")
    Book getByid(@Argument Long bookId){
        return bookService.getOne(bookId);
    }
}
