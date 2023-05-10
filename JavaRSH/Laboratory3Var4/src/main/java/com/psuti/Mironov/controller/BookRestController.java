package com.psuti.Mironov.controller;

import com.psuti.Mironov.dao.BookRepository;
import com.psuti.Mironov.entity.Variant4.Book;
import com.psuti.Mironov.entity.Variant4.BookProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;


@RequestMapping("/books")
@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    @Autowired
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    BookService bookService;

    @GetMapping
    public List<BookProjection> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books_full")
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getById (@PathVariable("id") UUID id){
        return bookRepository.findById(id).get();
    }


    @PutMapping
    public Book update (@RequestBody Book book){
        if(bookRepository.existsById (book.getId())) {
            return bookRepository.save(book);
        }
        throw new EntityExistsException("Book with id:'"+ book.getId() +"' doesn't exists");
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        UUID id = book.getId();
        if(id!=null){
            if(bookRepository.existsById(book.getId())){
                throw new EntityExistsException("Book already exists");
            }
        }
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable("id") UUID id){
        bookRepository.deleteById(id);
    }
}
