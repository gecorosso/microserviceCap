package com.codicefiscale.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Book {

	@EmbeddedId
	@Getter @Setter
	@Id
	private BookId id;
	
	@Getter @Setter
	@Column(name="genere")
	private String genere;
	
	@Getter @Setter
	@Column(name="prezzo")
	private Integer prezzo;

}
