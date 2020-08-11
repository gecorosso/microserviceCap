package com.codicefiscale.entity;

import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="Persona")
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
	@Id
	@GeneratedValue
	@Getter @Setter
	private Long persona_id;
	
	@Getter @Setter
	@CreationTimestamp
	Timestamp data_inserimento;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String cognome;
    
	@Getter @Setter
	private String eta;
	
	
	
}
