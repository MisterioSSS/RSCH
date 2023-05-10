package com.psuti.Zhalnin.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="uuid")
    @Column (name = "name", nullable = false)
    private String name;


/*
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

 */

}
