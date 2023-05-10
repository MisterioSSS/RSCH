package com.psuti.Zhalnin.controller;

import com.psuti.Zhalnin.DTO.AuthDto;
import com.psuti.Zhalnin.DTO.RegDto;
import com.psuti.Zhalnin.entity.Token;
import com.psuti.Zhalnin.service.UserAuthService;
import com.psuti.Zhalnin.service.UserRegService;
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
