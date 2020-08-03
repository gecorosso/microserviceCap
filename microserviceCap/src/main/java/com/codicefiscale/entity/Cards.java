package com.codicefiscale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="CARDS")
@NoArgsConstructor

public class Cards {
	
	@OneToOne(mappedBy = "card")
	@Getter @Setter
	private Clienti clienti;
	
	@Id
	@Column(name="CODFIDELITY")
	@Getter @Setter
	private String codFidelity; 
	
	@Column(name="BOLLINI")
	@Getter @Setter
	private String bollini;

    @Column(name="ULTIMASPESA")
    @Getter @Setter
    private String ultimaSpesa;
	
    @Column(name="OBSOLETO")
    @Getter @Setter
    private String obsoleto;
	
}
