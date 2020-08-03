package com.codicefiscale.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PARAMETRI")

public class Parametri {
	@Id
	@Column(name="id")
	@Getter	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="param")
	@Getter @Setter
	@NotBlank(message = "LO DEVI DA POPOLAREEE")
	@Length(min=0, max=5, message = "Dimensione compresa tra 0 e 5 ")
	private String param;
	
	@Column(name="dataInizio")
	@Getter @Setter
	@FutureOrPresent(message = "Valida solo Data futura o presente")
	private Date dataInizio;
	
	@Column(name="mail")
	@Getter @Setter
	@Email(message="mail non corretta")
	private String mail;
	
}
