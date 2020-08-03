package com.codicefiscale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.*;


@Entity
@Table(name="UTENTE")

/*OLD OLD OLD*/
public class Utente {
	@Id
	@Column(name="id")
	@Getter @Setter
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="username",length = 25 )
	@Getter @Setter
	@Length(min=0,max=25)
	@NotNull @NotEmpty @NotBlank(message = "Il campo Username deve essere Popolato XXX")
	private String username;
	
	@Column(name="psw",length = 50)
	@Getter @Setter
	@Length(min=0,max=50)
	@NotNull @NotEmpty @NotBlank(message = "Il campo Password deve essere Popolato")
	private String psw;
	
	@Column(name="permission",length = 25)
	@Getter @Setter
	@Length(min=0,max=25)
	@NotNull @NotEmpty @NotBlank(message = "Il campo Permission deve essere Popolato")
	private String permission;
	
}
