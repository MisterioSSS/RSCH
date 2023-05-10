package com.psuti.Mironov.service;

import com.psuti.Mironov.dto.AuthDto;
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

