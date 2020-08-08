package com.codicefiscale.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codicefiscale.entity.Dottore;
import com.codicefiscale.entity.Paziente;
import com.codicefiscale.service.DottoreService;
import com.codicefiscale.service.PazienteService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Controller
@ResponseBody
//@org.springframework.web.bind.annotation.RestController
//@ComponentScan({"com.codicefiscale.service."})
public class RestControllerDue {
	final Logger log = LoggerFactory.getLogger(RestControllerDue.class);
	
	@Autowired PazienteService pazienteService;
	@Autowired DottoreService dottoreService;
	
	@AllArgsConstructor
	public class JsonResponseBody{
		@Getter @Setter
		private int server;
		@Getter @Setter
		private Object response;
	}
	
	@RequestMapping(value="/insertPaziente", method = RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> moltiMolti(Paziente paziente,BindingResult bindingResult){
			log.info("==****==SONO DENTRO A MOLTI  MOLTI==****==");
			
			if (bindingResult.hasErrors()) {
				log.info("******NO BUONO******");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(
						HttpStatus.FORBIDDEN.value(), bindingResult.getAllErrors().get(0).getCode()));
			
			}
			
			Paziente app = pazienteService.savePaziente(paziente);
			
			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), app));
	}
	
	@RequestMapping(value="/getTuttiPazienti", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody>getTuttiPazienti(){
		List<Paziente> app = pazienteService.getAllPaziente();
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), app));
	} 
	
	@RequestMapping(value="/getPazienteDaCognome", method=RequestMethod.POST)
	public ResponseEntity<JsonResponseBody> getPazienteDaCognome(Paziente paziente,BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
			log.info("******NO BUONO******");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(
					HttpStatus.FORBIDDEN.value(), bindingResult.getAllErrors().get(0).getCode()));
		}
		
		List<Paziente> app = pazienteService.getPazienteFromCognome(paziente.getCognome()); 
		
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), app));		
		
	}
	
	@RequestMapping(value="/insertDottore", method = RequestMethod.POST)
	public  ResponseEntity<JsonResponseBody> insertDottore (Dottore dottore,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			log.info("******NO BUONO******");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(
					HttpStatus.FORBIDDEN.value(), bindingResult.getAllErrors().get(0).getCode()));
		}
		
		Dottore app = dottoreService.saveDottore(dottore); 
		
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), app));
	}
	
	@RequestMapping(value="/associaMedicoPaziente", method=RequestMethod.POST)
	public  ResponseEntity<JsonResponseBody> associaMedicoPaziente (Dottore dottore,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			log.info("******NO BUONO******");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(
					HttpStatus.FORBIDDEN.value(), bindingResult.getAllErrors().get(0).getCode()));
		}
		
		log.info("Leggiamo tutti i pazienti e li inseriamo in una lista");
		List<Paziente> listPazientiii = pazienteService.getAllPaziente();
		
		dottore.setPaziente(listPazientiii);
		Dottore app = dottoreService.saveDottore(dottore); 
		
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), app));
		
	}
	
	@RequestMapping(value="/getPazientiFromMedico", method=RequestMethod.POST)
	public  ResponseEntity<JsonResponseBody> getPazientiFromMedico (Dottore dottore,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			log.info("******NO BUONO******");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(
					HttpStatus.FORBIDDEN.value(), bindingResult.getAllErrors().get(0).getCode()));
		}
		
		Object app = dottoreService.getAllPazienteFromDottore(dottore);
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), app));
	}
	
	
	
	
}
