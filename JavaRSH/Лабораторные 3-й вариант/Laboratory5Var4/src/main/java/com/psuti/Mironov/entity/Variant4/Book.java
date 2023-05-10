package com.psuti.Mironov.entity.Variant4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id" , nullable = false)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 25)
    private Integer pagecount;

    @Column(nullable = false, length = 25)
    private Integer yearofissue;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;

}



