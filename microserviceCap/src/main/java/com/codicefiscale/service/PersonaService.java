package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import com.codicefiscale.entity.Persona;

public interface PersonaService {
	List<Persona> getAllPersone() throws EntityNotFoundException;
	Persona postPersona(Persona persona) throws EntityNotFoundException;
}
