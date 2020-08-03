package com.codicefiscale.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Dottore")

public class Dottore {
	@Getter @Setter
	@Id
	@GeneratedValue
	private Long dottore_id;
	
	@ManyToMany (cascade = {CascadeType.ALL})
	@JoinTable(
			name="JoinDottPazient",
			joinColumns = {@JoinColumn(name="dottore_id")},
			inverseJoinColumns = {@JoinColumn(name="paziente_id")}
	)
	
	@Getter @Setter
	List<Paziente> paziente = new ArrayList<>();
	
	@Getter @Setter
	private String matricola;
	
	@Getter @Setter
	private String specializzazione;
	
	
}
