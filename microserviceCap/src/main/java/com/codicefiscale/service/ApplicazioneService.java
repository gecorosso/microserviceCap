package com.codicefiscale.service;

import javax.persistence.EntityNotFoundException;

import com.codicefiscale.entity.Applicazione;

public interface ApplicazioneService {
	public Applicazione saveApplicazione(Applicazione applicazione) throws EntityNotFoundException;
}
