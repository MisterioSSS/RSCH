package com.psuti.Zhalnin.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="uuid")
    @Column(name = "users_id", nullable = false)
    private UUID id;
    @Column(nullable = false, length = 25,name = "firstname")
    private String firstname;
    @Column(nullable = false, length = 25, name = "lastname")
    private String lastname;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    @JsonIgnore
    private boolean enabled = true;

/*
    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Role> roles = new HashSet<>();

 */

}



