package com.psuti.Mironov.service;

import com.psuti.Mironov.dto.RegDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnRegistrationEvent {
    private RegDto regDto;
    public OnRegistrationEvent(RegDto regDto){
        this.regDto = regDto;
    }
}
