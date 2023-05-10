package com.psuti.Mironov.entity.Variant4;



import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "authors")
public class Author implements Serializable {
    @Id
    @Column(name= "name" , nullable = false)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
