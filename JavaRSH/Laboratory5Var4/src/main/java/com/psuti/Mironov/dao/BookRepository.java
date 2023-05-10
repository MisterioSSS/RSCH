package com.psuti.Mironov.dao;

import com.psuti.Mironov.entity.Variant4.BookProjection;
import com.psuti.Mironov.entity.Variant4.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;


public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query( value = "Select CAST(id as varchar) id, name, author from books", nativeQuery = true)
    List <BookProjection> getAllBooks();
}
