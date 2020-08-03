package com.codicefiscale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comuneitalia")

@AllArgsConstructor
@NoArgsConstructor

public class ComuneItalia {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

@Getter @Setter
private int idIstat;


@Getter @Setter
@NotBlank(message="Il campo Istat deve essere POPOLATO")
private String Istat;



@Getter @Setter
@NotBlank(message="Il campo COMUNE deve essere POPOLATO")
@Length(min = 0, max=50)
private String Comune;     


@Getter @Setter
@Length(min = 0, max=50)
private String Provincia;


@Getter @Setter
@Length(min = 0, max=20)
private String Regione;


@Getter @Setter
@Length(min = 0, max=10)
private String Prefisso;


@Getter @Setter
@Length(min = 5)
private String CAP;  


@Getter @Setter
private String CodFisco;


@Getter @Setter
private String Abitanti;


@Getter @Setter
@Length(min = 0, max=60)
private String Link;
	
	
}
