package com.codicefiscale.service;


import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.codicefiscale.entity.Bottiglia;


public interface BottigliaService {
	Bottiglia saveBottiglia(Bottiglia bottiglia) throws EntityNotFoundException;	
	List<Bottiglia> getAllEtichette() throws EntityNotFoundException;
	void deleteItemBottiglia(Long id) throws EntityNotFoundException;
	
	    
}
