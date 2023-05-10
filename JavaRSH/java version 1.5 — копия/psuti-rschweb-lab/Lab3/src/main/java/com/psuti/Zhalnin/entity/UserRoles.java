package com.psuti.Zhalnin.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "users_roles")
public class UserRoles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="uuid")
    @Column(name = "id", nullable = false)
    private UUID id;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;





    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="film_id")
    private Film film;



    @Column(name= "role" , nullable = false)
    private String role;

/*
    @ManyToMany(mappedBy = "film")
    private Set<Film> film1 = new HashSet<>();
    Test
 */


}
