package com.codicefiscale.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Utenti implements Serializable {
	private static final long serialVersionUID = -5744776152192138785L;
  
	@OneToOne
	@PrimaryKeyJoinColumn
	@Getter @Setter
	private Clienti clienti;
	
	//Essendo Uno a molti usa um HashSet...
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="utente",orphanRemoval=true)
	private Set<Profili> profili =new HashSet<>();
	
	@Id	
	@Column(name="CODFIDELITY")
	@Getter @Setter
	private String codFidelity;
	
	@Column(name="USERID")
	@Getter @Setter
	private String userId;
	
	@Column(name="PASSWORD")
	@Getter @Setter
	private String password;
	
	@Column(name="ABILITATO")
	@Getter @Setter
	private String abilitato;
	
	
	public Utenti(String CodFidelity)
	{
		this.codFidelity = CodFidelity;
	}
}
