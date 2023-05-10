package com.psuti.Mironov.entity.Variant4;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

}
