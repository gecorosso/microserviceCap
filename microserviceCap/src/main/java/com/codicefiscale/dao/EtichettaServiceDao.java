package com.codicefiscale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codicefiscale.entity.Etichetta;

public interface EtichettaServiceDao extends JpaRepository<Etichetta, String>{
	@Query(value="SELECT * FROM Etichetta", nativeQuery =true)
	List<Etichetta> soloEtichette();
}
