package com.psuti.Slastunov.service;

import com.psuti.Slastunov.dto.AuthDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnAuthorizationEvent {
    private AuthDto authDto;
    public OnAuthorizationEvent(AuthDto authDto){
        this.authDto = authDto;
    }
}

