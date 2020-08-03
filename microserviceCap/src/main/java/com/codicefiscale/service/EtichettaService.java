package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.codicefiscale.entity.Etichetta;

public interface EtichettaService {
	List<Etichetta> getSoloUnaEtichetta() throws EntityNotFoundException;
	
	Long getTotaleEtichette() throws EntityNotFoundException;
}
