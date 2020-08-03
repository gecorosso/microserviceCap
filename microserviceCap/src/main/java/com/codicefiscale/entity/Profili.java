package com.codicefiscale.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Table(name="PROFILI")
public class Profili implements Serializable {
	
	private static final long serialVersionUID = 939456989960555859L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private long id;
	
	
	@Column(name="TIPO")
	@Getter @Setter
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="CODFIDELITY",referencedColumnName = "codFidelity")
	@Getter @Setter
	private Utenti utente;
	
}
