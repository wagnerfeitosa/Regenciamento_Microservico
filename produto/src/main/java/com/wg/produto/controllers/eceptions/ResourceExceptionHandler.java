package com.wg.produto.controllers.eceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wg.produto.service.exceptios.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError errorStandard = new StandardError(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(errorStandard);
	}

}
