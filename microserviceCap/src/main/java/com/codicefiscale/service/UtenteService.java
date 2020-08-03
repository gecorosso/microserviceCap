package com.codicefiscale.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import com.codicefiscale.entity.Utente;



public interface UtenteService  {
	Utente saveUtente(Utente utente) throws EntityNotFoundException;
	List<Utente> findUtenteByUser(String username) throws EntityNotFoundException;
	Optional<Utente> getInfoForJwt(String user,String psw) throws EntityNotFoundException; 
	
	String generateJwt(String subject, Date date, String name, String scope) throws java.io.UnsupportedEncodingException;
	Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws  UnsupportedEncodingException;
	
}
