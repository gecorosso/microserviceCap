package com.codicefiscale.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Device")

@AllArgsConstructor
@NoArgsConstructor
public class Device {
	@Id
	@GeneratedValue
	@Getter @Setter
	@Column(name="id")
	private int id;
	
	@Getter @Setter
	@Column(name="nomeDev")
	private String nomeDev;
	
	@Getter @Setter
	@Column(name="marchioDev")
	private String marchioDev;
	
	@Getter @Setter
	@Column(name="batteriaDev")
	private String batteriaDev;
	
	@Getter @Setter
	@Column(name="antennaDev")
	private String antennaDev;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="id")
	private Set<Applicazione> applicazione = new HashSet<Applicazione>();
	
}
