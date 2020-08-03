package com.codicefiscale.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="paziente")
public class Paziente {
	@ManyToMany(mappedBy="paziente")
	private Set<Dottore> dottore = new HashSet<>();
	
	@Getter @Setter
	@Id
	@GeneratedValue
	private Long paziente_id;
	
	@Getter @Setter
	private String cognome;
	
	@Getter @Setter
	private String malattia;
	
}
