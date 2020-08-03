package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.BottigliaServiceDao;
import com.codicefiscale.dao.BottigliaServiceDaoCrud;
import com.codicefiscale.entity.Bottiglia;

@Service
public class BottigliaServiceImpl implements BottigliaService {
    
	Logger log = LoggerFactory.getLogger(BottigliaServiceImpl.class);
	
	@Autowired
	BottigliaServiceDao bottigliaServiceDao;
	@Autowired
	BottigliaServiceDaoCrud bottigliaServiceDaoCrud;
	
	@Override
	public Bottiglia saveBottiglia(Bottiglia bottiglia) throws EntityNotFoundException {
		log.info("*****Sono dentro a saveBottiglia*******");
		return bottigliaServiceDao.save(bottiglia);
	}
	
	@Override
	public List<Bottiglia> getAllEtichette() throws EntityNotFoundException {
		log.info("Estrapolo Tutte le bottiglie");
		return bottigliaServiceDao.findAll();
	}

	@Override
	public void deleteItemBottiglia(Long id) throws EntityNotFoundException {
		bottigliaServiceDaoCrud.deleteById(id);
	}

	
	
	
}
