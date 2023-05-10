package com.psuti.Zhalnin.controller;

import com.psuti.Zhalnin.dao.UserRepository;
import com.psuti.Zhalnin.entity.User;
import com.psuti.Zhalnin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;


@RequestMapping("/users")
@RestController
public class UserRestController {

    private final UserRepository userRepository;
    @Autowired
    public UserRestController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") UUID id){
        return userRepository.findById(id).get();
    }


    @Secured("ROLE_ADMIN")
    @PutMapping
    public User update(@RequestBody User user){
        if(userRepository.existsById(user.getId())){
            return userRepository.save(user);
        }
        throw new EntityExistsException("User with id:'"+ user.getId() +"' doesn't exists");
    }
    @Secured("ROLE_ADMIN")
    @PostMapping
    public User create(@RequestBody User user){
        UUID id = user.getId();
        if(id !=null){
            if(userRepository.existsById(user.getId())){
                throw new EntityExistsException("User already exists");
            }
        }
        return userRepository.save(user);
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        userRepository.deleteById(id);
    }
}