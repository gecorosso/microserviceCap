package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.PazienteDao;
import com.codicefiscale.entity.Paziente;

@Service
public class PazienteServiceImpl implements PazienteService {
	
	@Autowired
	PazienteDao pazienteDao;
	
	@Override
	public Paziente savePaziente(Paziente paziente) throws EntityNotFoundException {
		return pazienteDao.save(paziente);
	}

	@Override
	public List<Paziente> getAllPaziente() throws EntityNotFoundException {		
		return pazienteDao.findAll();
	}

	@Override
	public List<Paziente> getPazienteFromCognome(String cognome) {
		return pazienteDao.findPazienteByCognome(cognome);
	}	
	
	

}
