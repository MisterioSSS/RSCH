package com.psuti.Itruhin.entity.example;


import javax.persistence.*;
import java.io.*;
import java.util.UUID;

@Entity
@Table(name = "user_roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id" , nullable = false)
    private UUID id;

    @Column(nullable = false, length = 25)
    private String name;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
