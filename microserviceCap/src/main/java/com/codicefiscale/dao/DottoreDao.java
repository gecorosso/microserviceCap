package com.codicefiscale.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codicefiscale.entity.Dottore;

@Repository
public interface DottoreDao extends JpaRepository<Dottore, String> {
	// viene utilizzato un Object proprio perchè il risultato della
	// query non ha una entity 
	@Query(value="SELECT d.matricola , d.specializzazione , p.cognome ,p.malattia FROM dottore d " + 
			"INNER JOIN joindottpazient j " + 
			"on j.dottore_id = d.dottore_id " + 
			"inner join paziente p " + 
			"on p.paziente_id = j.paziente_id WHERE d.matricola = :matricola", nativeQuery =true)
	List<Object>getAllMedicoPaziente(@Param("matricola") String matricola);
}
