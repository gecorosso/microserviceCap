package com.codicefiscale.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CLIENTI")
@NoArgsConstructor
public class Clienti implements Serializable{	
	private static final long serialVersionUID = -937097910035764021L;	
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@Getter @Setter
	private Cards card;
		
	
	
	@OneToOne(mappedBy = "clienti", cascade = CascadeType.ALL, orphanRemoval = true)
	@Getter @Setter
	private Utenti utenti;
	
	@Id
	@Column(name="CODFIDELITY")
	@Getter @Setter
	private String codFidelity;	 
	
	@Column(name="NOME")
	@Getter @Setter
	private String nome;

	@Column(name="COGNOME")
	@Getter @Setter
	private String cognome;

	@Column(name="INDIRIZZO")
	@Getter @Setter
	private String indirizzo;

	@Column(name="COMUNE")
	@Getter @Setter
	private String comune;

	@Column(name="CAP")
	@Getter @Setter
	private String cap;

	@Column(name="PROV")
	@Getter @Setter
	private String prov;

	@Column(name="TELEFONO")
	@Getter @Setter
	private String telefono;

	@Column(name="MAIL")
	@Getter @Setter
	private String mail;

	@Temporal(TemporalType.DATE)
	@Column(name="DATACREAZ")
	@Getter @Setter
	private Date dataCreaz;


}
