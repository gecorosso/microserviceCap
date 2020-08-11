package com.codicefiscale.dto;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.codicefiscale.entity.Persona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {
	public PersonaDto(Persona entity) {
		this.nome=entity.getNome();
		this.cognome=entity.getCognome();
		this.eta=entity.getEta();
	}
	
	@Getter @Setter
	private Long persona_id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String cognome;
    
	@Getter @Setter
	private String eta;
}
