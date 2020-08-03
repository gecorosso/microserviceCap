package com.codicefiscale.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.DottoreDao;
import com.codicefiscale.entity.Dottore;

@Service
public class DottoreServiceImpl implements DottoreService{
	@Autowired DottoreDao dottoreDao;
	
	@Override
	public Dottore saveDottore(Dottore dottore) throws EntityNotFoundException {
		
		return dottoreDao.save(dottore);
	}

	@Override
	public Object getAllPazienteFromDottore(Dottore dottore) throws EntityNotFoundException {
		return dottoreDao.getAllMedicoPaziente(dottore.getMatricola());
	}

}
