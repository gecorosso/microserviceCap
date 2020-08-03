package com.codicefiscale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="Bottiglia")
@SecondaryTable(name="Etichetta", pkJoinColumns = @PrimaryKeyJoinColumn(name="id"))

@AllArgsConstructor
@NoArgsConstructor

public class Bottiglia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	@Column(name="id")
	private Long id;
	
	@Getter @Setter
	@Column(name="formato")
	private String formato;
	
	@Getter @Setter
	@Column(name="colore")
	private String colore;
	
	@Getter @Setter
	@Column(name="materiale")
	private String materiale;
	
	//==Inizio Etichetta
	
	@Getter @Setter
	@Column(name="forma", table = "Etichetta")
	private String forma;
	
	@Getter @Setter
	@Column(name="intestazione", table = "Etichetta")
	private String intestazione;
	
	@Getter @Setter
	@Column(name="scadenza", table = "Etichetta")
	private String scadenza;
	
}
