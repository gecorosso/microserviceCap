package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.EtichettaServiceDao;
import com.codicefiscale.entity.Etichetta;

@Service
public class EtichettaServiceImpl implements EtichettaService {
	@Autowired EtichettaServiceDao etichettaServiceDao;
	
	@Override
	public List<Etichetta> getSoloUnaEtichetta() throws EntityNotFoundException {
		//return etichettaServiceDao.soloEtichette();
		
		return etichettaServiceDao.findAll();
	}

	@Override
	public Long getTotaleEtichette() throws EntityNotFoundException {
		return etichettaServiceDao.count();
	}

}
