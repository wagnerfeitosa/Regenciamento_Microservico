package com.wg.controller_producao.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Recurso não encontrado id: "+id);
	}

}
