package com.psuti.Zhalnin.controller;

import com.psuti.Zhalnin.dao.UserRolesRepository;

import com.psuti.Zhalnin.entity.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;


@RequestMapping("/movie")
@RestController
public class MoviesRestController {

    private final UserRolesRepository movieRepository;

    @Autowired
    public MoviesRestController(UserRolesRepository movieRepository) {
        this.movieRepository = movieRepository;
    }



    @GetMapping
    public List<UserRoles> getAll(){
        return movieRepository.findAll();
    }
    @GetMapping("/{id}")
    public UserRoles getById (@PathVariable("id") UUID id){
        return movieRepository.findById(id).get();
    }

    @PutMapping
    public UserRoles update (@RequestBody UserRoles movie){
        if(movieRepository.existsById (movie.getId())) {
            return movieRepository.save(movie);
        }
        throw new EntityExistsException("User with id:'"+ movie.getId() +"' doesn't exists");
    }

    @PostMapping
    public UserRoles create(@RequestBody UserRoles movie){
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable("id") UUID id){
        movieRepository.deleteById(id);
    }

}
