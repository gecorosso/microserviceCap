package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.ComuneServiceDao;
import com.codicefiscale.entity.ComuneItalia;
import com.codicefiscale.util.EntityNotFoundExceptionById;

@Service
public class ComuneServiceImpl implements ComuneService {
	
	Logger log = LoggerFactory.getLogger(ComuneServiceImpl.class);
	
	@Autowired
	ComuneServiceDao comuneServiceDao;
	
	@Override
	public List<ComuneItalia> getAllRighePerComune(String istat) throws EntityNotFoundException {
		log.info("ENTRATO==getAllRighePerComune()-->"+istat);
		List<ComuneItalia> cIta = comuneServiceDao.findUserByIstat(istat);
		return cIta;
	}
	
	@Override
	public List<ComuneItalia> findAll() throws EntityNotFoundException {
		return comuneServiceDao.findAll();
	}

	@Override
	public ComuneItalia saveComuneItalia(ComuneItalia comuneItalia) throws EntityNotFoundException  {
		log.info("Entrato in saveComuneItalia");
		return comuneServiceDao.save(comuneItalia);
	}

	
	@Override
	public void deleteItemComuneItalia(ComuneItalia comuneItalia) throws EntityNotFoundExceptionById {
		log.info("deleteItemComuneItalia");
		    
		   List<ComuneItalia> myList = comuneServiceDao.findPerId(comuneItalia.getIdIstat()); 
		   		    
		    if(myList.size()==0) {
		    	log.info("Riga NON esistente");
		    	throw new EntityNotFoundExceptionById("RIGA INESISTENTE");
		    }else{ 		
			    comuneServiceDao.delete(comuneItalia);
		    }
	}

	@Override
	public void deleteIGroupComuneItalia(List<ComuneItalia> comuneItaliaGroup) throws EntityNotFoundException {
		log.info("deleteIGroupComuneItalia");
		comuneServiceDao.deleteAll(comuneItaliaGroup);
	}

	@Override
	public ComuneItalia updateRigaComuneItalia(ComuneItalia comuneItalia) throws EntityNotFoundException {
		log.info("==updateRigaComuneItalia==");
		return comuneServiceDao.save(comuneItalia);
	}

}
