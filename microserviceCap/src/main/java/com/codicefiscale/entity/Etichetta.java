package com.codicefiscale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Etichetta")
public class Etichetta {
	//==Inizio Etichetta
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter @Setter
		@Column(name="id")
		private Long id;
		
	
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
