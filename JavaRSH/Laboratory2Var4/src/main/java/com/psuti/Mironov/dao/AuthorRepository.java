package com.psuti.Mironov.dao;

import com.psuti.Mironov.entity.Variant4.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository <Author, String> {
}
