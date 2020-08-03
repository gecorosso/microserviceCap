package com.codicefiscale.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class BookId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="author")
	@Getter @Setter
	private String author;
    
	@Column(name="name")
	@Getter @Setter
	private String name;

}
