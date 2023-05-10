package com.psuti.Zhalnin.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="uuid")
    @Column(name = "film_id", nullable = false)
    private UUID id;

    @Column(nullable = false, length = 25)
    private String name;



/*
    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Film> film = new HashSet<>();

 */


}
