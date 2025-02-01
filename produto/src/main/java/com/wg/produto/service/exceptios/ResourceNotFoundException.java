package com.wg.produto.service.exceptios;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Recurso Não encontrado id: "+id);
	}

}
