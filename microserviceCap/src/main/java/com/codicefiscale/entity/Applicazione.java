package com.codicefiscale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name="Applicazione")
public class Applicazione {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Getter @Setter
	@Column(name="tipoApp")
	private String tipoApp;
	
	@Getter @Setter
	@Column(name="nomeApp")
	private String nomeApp;
	
	@Getter @Setter
	@Column(name="distributoreApp")
	private String distributoreApp;
	
	@ManyToOne
	@JoinColumn(name="id", insertable = false, updatable = false, nullable = false)
	
	
	@Getter @Setter
	private Device device;
	
}
