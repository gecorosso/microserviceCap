package com.codicefiscale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codicefiscale.entity.Bottiglia;

public interface BottigliaServiceDao extends JpaRepository<Bottiglia, String> {
	//Inserisce nella tabella Bottiglia ed Etichetta
	
	//InnerJoin che lega due tabelle con id comune
	//SELECT * FROM Bottiglia b INNER JOIN Etichetta e ON b.id=e.id WHERE b.id=96
	
	//@Query(value="SELECT * FROM comuneitalia WHERE istat = :istat", nativeQuery =true)
	//List<ComuneItalia> findUserByIstat(@Param("istat") String istat);
	//@Query(value="SELECT * FROM bottiglia",nativeQuery = true)
	//List<Bottiglia> soloEtichette();
	
}
