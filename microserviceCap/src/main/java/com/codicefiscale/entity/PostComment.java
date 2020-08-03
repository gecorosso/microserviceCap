package com.codicefiscale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PostComment")
@Table(name = "post_comment")

public class PostComment {
	@Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
 
	@Getter @Setter
    private String review;
}
