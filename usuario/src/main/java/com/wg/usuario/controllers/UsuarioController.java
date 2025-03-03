package com.wg.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wg.usuario.dtos.UsuarioRecordDto;
import com.wg.usuario.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioRecordDto> salvar(@RequestBody @Validated UsuarioRecordDto usuarioDto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuarioDto));
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioRecordDto>> findAll(){
		
		List<UsuarioRecordDto> usuarios = usuarioService.findAll();
		
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping(value = "/{idusuario}")
	public ResponseEntity<UsuarioRecordDto> findById(@PathVariable String idusuario){
		
		return ResponseEntity.ok().body(usuarioService.findById(idusuario));
	}
	
	@GetMapping(value = "/buscaPorNome/{name}")
	public ResponseEntity<List<UsuarioRecordDto>> buscaPorNome(@PathVariable String name){
		
		return ResponseEntity.ok().body(usuarioService.buscaPorNome(name));
	}
	
	@DeleteMapping(value = "/{idusuario}")
	public ResponseEntity<Void> delete(@PathVariable String idusuario){
		
		 usuarioService.delete(idusuario);
		 
		 return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value ="/{idusuario}")
	public UsuarioRecordDto update(@PathVariable String idusuario,@RequestBody UsuarioRecordDto usuarioDto) {
		
		return usuarioService.update(idusuario, usuarioDto);
		
	}

}
