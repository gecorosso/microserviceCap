package com.codicefiscale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codicefiscale.entity.Persona;

@Repository
public interface PersonaDao extends JpaRepository<Persona, String> {
	
}
