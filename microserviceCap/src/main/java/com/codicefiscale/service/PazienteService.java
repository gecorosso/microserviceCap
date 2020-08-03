package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.codicefiscale.entity.Paziente;


public interface PazienteService {
	public Paziente savePaziente(Paziente paziente) throws EntityNotFoundException;
	public List<Paziente> getAllPaziente() throws EntityNotFoundException;
	public List<Paziente> getPazienteFromCognome(String cognome);
	
}
