package com.wg.usuario.controller.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wg.usuario.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError standardError = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}

}
