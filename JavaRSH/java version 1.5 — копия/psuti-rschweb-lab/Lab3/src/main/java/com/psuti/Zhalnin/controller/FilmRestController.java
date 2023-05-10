package com.psuti.Zhalnin.controller;

import com.psuti.Zhalnin.dao.FilmRepository;
import com.psuti.Zhalnin.entity.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;


@RequestMapping("/film")
@RestController
public class FilmRestController {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmRestController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }



    @GetMapping
    public List<Film> getAll(){
        return filmRepository.findAll();
    }
    @GetMapping("/{id}")
    public Film getById (@PathVariable("id") UUID id){
        return filmRepository.findById(id).get();
    }

    @PutMapping
    public Film update (@RequestBody Film film){
        if(filmRepository.existsById (film.getId())) {
            return filmRepository.save(film);
        }
        throw new EntityExistsException("User with id:'"+ film.getId() +"' doesn't exists");
    }

    @PostMapping
    public Film create(@RequestBody Film film){
        return filmRepository.save(film);
    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable("id") UUID id){
        filmRepository.deleteById(id);
    }
}
