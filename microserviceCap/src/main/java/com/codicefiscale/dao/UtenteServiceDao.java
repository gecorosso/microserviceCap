package com.codicefiscale.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codicefiscale.entity.Utente;

@Repository
public interface UtenteServiceDao extends JpaRepository<Utente,String> {
	@Query(value="SELECT * FROM utente WHERE username = :username", nativeQuery =true)
	List<Utente> findUtenteByUser(@Param("username") String username);
	
	@Query(value="SELECT * FROM utente WHERE username = :username AND psw = :password", nativeQuery =true)
	Optional<Utente> findUtenteByUserAndPassword(@Param("username") String username,@Param("password") String password);
	
}
