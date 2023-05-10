package com.psuti.Mironov.entity;

import com.psuti.Mironov.entity.example.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity(name = "verificationToken")
@Table(name = "verification_tokens")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String token;
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    private Date expiryDate;
    private boolean confirmed;
}
