package com.psuti.Itruhin.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PostBody implements Serializable {
    private String type;
    private String data;
}

