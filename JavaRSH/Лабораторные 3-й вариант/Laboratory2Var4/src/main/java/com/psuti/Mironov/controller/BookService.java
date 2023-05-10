package com.psuti.Mironov.controller;

import com.psuti.Mironov.dao.BookRepository;
import com.psuti.Mironov.entity.Variant4.BookProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<BookProjection> getBooks(){
        return bookRepository.getAllBooks();
    }

}
