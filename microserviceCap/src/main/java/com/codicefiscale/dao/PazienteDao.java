package com.codicefiscale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codicefiscale.entity.Paziente;

@Repository
public interface PazienteDao extends JpaRepository<Paziente,String> {
	@Query(value="SELECT * FROM paziente WHERE cognome=:cognome", nativeQuery=true)
	List<Paziente> findPazienteByCognome(@Param("cognome") String cognome);
}
