package com.wg.pedido.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wg.pedido.dtos.UsuarioDto;

@FeignClient(name = "Usuario-service", url = "http://localhost:8081/usuarios")
public interface UsuarioServiceClient {
	
	@GetMapping(value = "/{idusuario}")
	UsuarioDto usuario (@PathVariable("idusuario") String idusuario);

}
