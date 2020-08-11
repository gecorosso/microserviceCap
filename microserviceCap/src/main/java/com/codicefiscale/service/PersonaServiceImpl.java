package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.PersonaDao;
import com.codicefiscale.entity.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired PersonaDao personaDao;
	
	@Override
	public List<Persona> getAllPersone() throws EntityNotFoundException {	
		return personaDao.findAll();
	}

	@Override
	public Persona postPersona(Persona persona) throws EntityNotFoundException {
		return personaDao.save(persona);
	}

}
