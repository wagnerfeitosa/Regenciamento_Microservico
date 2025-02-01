package com.wg.controller_producao.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wg.controller_producao.dtos.UsuarioDto;

@FeignClient(name = "service-usuario", url = "http://localhost:8081/usuarios")
public interface UsuarioServiceClient {
	
	@GetMapping(value = "/{idusuario}")
	UsuarioDto usuario (@PathVariable("idusuario") String idusuario);

}
