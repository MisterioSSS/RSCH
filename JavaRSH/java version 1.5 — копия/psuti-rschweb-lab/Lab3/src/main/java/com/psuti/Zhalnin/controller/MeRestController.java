package com.psuti.Zhalnin.controller;

import com.psuti.Zhalnin.DTO.UpdateDto;
import com.psuti.Zhalnin.DTO.UserInfo;
import com.psuti.Zhalnin.service.UserMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/me")
public class MeRestController {
    private final UserMeService userMeService;
    @Autowired
    public MeRestController(UserMeService userMeService) {
        this.userMeService = userMeService;
    }
    @GetMapping
    public UserInfo get(){
        return userMeService.get();
    }
    @PutMapping
    public UserInfo update(@RequestBody UpdateDto user){
        return userMeService.update(user);
    }
    @DeleteMapping
    public void remove(){
        userMeService.remove();
    }
}

