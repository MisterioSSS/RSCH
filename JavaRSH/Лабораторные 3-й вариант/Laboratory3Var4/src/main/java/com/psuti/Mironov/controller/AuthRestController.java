package com.psuti.Mironov.controller;

import com.psuti.Mironov.dto.AuthDto;
import com.psuti.Mironov.dto.RegDto;
import com.psuti.Mironov.entity.Token;
import com.psuti.Mironov.service.UserAuthService;
import com.psuti.Mironov.service.UserRegService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
    private final UserAuthService userAuthService;
    private final UserRegService userRegService;
    public AuthRestController(UserAuthService userAuthService,
                              UserRegService userRegService) {
        this.userAuthService = userAuthService;
        this.userRegService = userRegService;
    }
    @PostMapping(path = "/login")
    @RequestMapping(value = "/login")
    public Token createAuthenticationToken(@RequestBody AuthDto authenticationRequest)
            throws Exception {
        return userAuthService.authorization(authenticationRequest);
    }
    @PostMapping
    @RequestMapping("/reg")
    public Token createAccount(@RequestBody RegDto user) throws Exception {
        return userRegService.registration(user);
    }
}

