package com.codicefiscale.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundExceptionById extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EntityNotFoundExceptionById(String message) {
        super(message);
    }
}
