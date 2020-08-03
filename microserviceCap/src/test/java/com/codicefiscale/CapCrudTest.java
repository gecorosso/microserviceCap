package com.codicefiscale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codicefiscale.entity.ComuneItalia;
import com.codicefiscale.service.ComuneService;

@SpringBootTest
class CapCrudTest {
	@Autowired ComuneService comuneService;
	
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

}
