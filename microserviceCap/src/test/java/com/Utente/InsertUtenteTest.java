package com.Utente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codicefiscale.entity.Utente;
import com.codicefiscale.service.ComuneService;
import com.codicefiscale.service.UtenteService;

@SpringBootTest(classes = com.codicefiscale.MicroserviceCapApplication.class)
class InsertUtenteTest {
	
	@Autowired ComuneService comuneService;
	@Autowired UtenteService utenteService;
	
	
	private Utente creaUtente() {
		Utente ut = new Utente();
		ut.setId(1);
		ut.setPermission("utente");
		ut.setPsw("serpenteGiocoso");
		ut.setUsername("Codamozza");
		return ut;
	}
	
	
	@Test
	void insertUtente() {
		Utente utente = utenteService.saveUtente(this.creaUtente());
		
		assertEquals(this.creaUtente(), utente);
	}
	
	
	
	
	/*
	static final String istat="097001";
	static final int totRec=15;
	
	List<ComuneItalia> listaDiComuni; 
	
	@BeforeEach
	void initCap() {
		listaDiComuni = comuneService.getAllRighePerComune(istat);
	}
	
	@Test
	void testControllaRigheComune() {
		//List<ComuneItalia> listaDiComuni = comuneService.getAllRighePerComune(istat);
		//Mi carico un gruppo di record
		assertEquals(totRec, comuneService.getAllRighePerComune(istat).size());
	}
	
	@Test
	void deleteGruppoPerComune() {
		comuneService.deleteIGroupComuneItalia(listaDiComuni);
		assertEquals(0, comuneService.getAllRighePerComune(istat).size());
	
	}
	*/

}
