package com.wg.pedido.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wg.pedido.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError standardErro =  new StandardError(Instant.now(),status.value(),e.getMessage(),erro,request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardErro);
	}

}
