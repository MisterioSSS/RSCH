package com.psuti.Itruhin.entity;


import com.psuti.Itruhin.dto.PostBody;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "post")
@Table(name = "posts")
@TypeDef(name = "jsonb", typeClass = JsonType.class)

public class Post implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id" , nullable = false)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String title;

    @JoinColumn(name = "author_id", nullable = false)
    private UUID authorId;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "body")
    private List<PostBody> body;

    @CreationTimestamp
    private Date createdAt;


}

