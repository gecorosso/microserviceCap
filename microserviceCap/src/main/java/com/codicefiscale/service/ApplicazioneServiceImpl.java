package com.codicefiscale.service;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.ApplicazioneRepositoryDao;
import com.codicefiscale.dao.ApplicazioneRepositoryDaoCrud;
import com.codicefiscale.entity.Applicazione;

@Service
public class ApplicazioneServiceImpl implements ApplicazioneService {
	final Logger log = LoggerFactory.getLogger(ApplicazioneServiceImpl.class);
	
	@Autowired
	ApplicazioneRepositoryDaoCrud appRepositoryCrud;
    
    @Autowired
    ApplicazioneRepositoryDao appRepository;
    
    
    
	@Override
	public Applicazione saveApplicazione(Applicazione applicazione) throws EntityNotFoundException {
		log.info("***********Salva Applicazione***********");
		//applicazione.setDevice(device);
		
		return appRepository.save(applicazione);
	}
	
}
