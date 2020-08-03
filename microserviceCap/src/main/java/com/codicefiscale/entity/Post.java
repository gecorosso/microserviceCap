package com.codicefiscale.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Post")
@Table(name = "post")

public class Post {
 
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String title;
 
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    
    @Getter @Setter
    private List<PostComment> comments = new ArrayList<>();
}

