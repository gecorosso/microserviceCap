package com.codicefiscale.service;

import javax.persistence.EntityNotFoundException;

import com.codicefiscale.entity.Dottore;

public interface DottoreService {
	public Dottore saveDottore(Dottore dottore) throws EntityNotFoundException;
	public Object getAllPazienteFromDottore (Dottore dottore) throws EntityNotFoundException;

}
