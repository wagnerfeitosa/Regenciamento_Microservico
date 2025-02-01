package com.wg.controller_producao.exceptions;

public class ResourceNotFondException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFondException(String id) {
		super("Recurso não encontrado. id: "+id);
	}

}
