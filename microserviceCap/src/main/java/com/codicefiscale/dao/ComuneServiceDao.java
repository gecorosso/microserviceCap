package com.codicefiscale.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codicefiscale.entity.ComuneItalia;

@Repository
public interface ComuneServiceDao extends JpaRepository<ComuneItalia, String> {
	
	@Query(value="SELECT * FROM comuneitalia WHERE istat = :istat", nativeQuery =true)
	List<ComuneItalia> findUserByIstat(@Param("istat") String istat);
	
	@Query(value="SELECT * FROM comuneitalia WHERE idIstat = :idIstat", nativeQuery = true)
	List<ComuneItalia> findPerId(@Param("idIstat") int idIstat);
	
}
