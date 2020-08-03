package com.codicefiscale.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.UtenteServiceDao;
import com.codicefiscale.entity.Utente;
import com.codicefiscale.util.CriptaTesto;
import com.codicefiscale.util.JwtUtils;

@Service
public class UtenteServiceImpl implements UtenteService {
   Logger log = LoggerFactory.getLogger(UtenteServiceImpl.class);
	
   @Autowired
   UtenteServiceDao utenteServiceDao;
   
   @Autowired CriptaTesto criptaTesto;
   
   //@Autowired JwtUtils jwt_utils;
   
   
	@Override
	public Utente saveUtente(Utente utente) throws EntityNotFoundException {
		log.info("Salva Utente==Utente service Impl==");
		return utenteServiceDao.save(utente);
	}

	@Override
	public List<Utente> findUtenteByUser(String username) throws EntityNotFoundException {
		
		
		return utenteServiceDao.findUtenteByUser(username);
	}

	@Override
	public Optional<Utente> getInfoForJwt(String user, String psw) throws EntityNotFoundException {
		return utenteServiceDao.findUtenteByUserAndPassword(user, psw);
	}

	@Override
	public String generateJwt(String subject, Date date, String name, String scope)
			throws UnsupportedEncodingException {
		Date expDate = date;
	    expDate.setTime(date.getTime()+(300*1000));
	    log.info("Questa sessione scadrà nel: " + expDate.getTime());    
	    
	    return JwtUtils.generateJwt(subject, expDate, name, scope);
	}

	@Override
	public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UnsupportedEncodingException {
		//Ricavi la stringa 
		String jwt = JwtUtils.getJwtFromHttpRequest(request);
		
		if(jwt==null) {
			throw new UnsupportedEncodingException("Jwt NON TROVATO!!!");
		}
		
		Map<String, Object> datiEstrapolati = JwtUtils.jwt2Map(jwt);
		return datiEstrapolati;
	}

	
	
	
	
	

}
