
package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.codicefiscale.entity.ComuneItalia;
import com.codicefiscale.util.EntityNotFoundExceptionById;

public interface ComuneService {
	List<ComuneItalia> getAllRighePerComune (String istat) throws EntityNotFoundException;
	List<ComuneItalia> findAll () throws EntityNotFoundException;
	ComuneItalia saveComuneItalia (ComuneItalia comuneitalia) throws EntityNotFoundException ;
	void deleteItemComuneItalia(ComuneItalia comuneItalia) throws EntityNotFoundExceptionById;
	void deleteIGroupComuneItalia(List<ComuneItalia> comuneItaliaGroup) throws EntityNotFoundException ;
	ComuneItalia updateRigaComuneItalia(ComuneItalia comuneItalia) throws EntityNotFoundException;
}
