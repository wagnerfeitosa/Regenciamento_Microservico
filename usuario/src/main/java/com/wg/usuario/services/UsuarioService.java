package com.wg.usuario.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.usuario.dtos.UsuarioRecordDto;
import com.wg.usuario.models.UsuarioModel;
import com.wg.usuario.producers.UsuarioProducer;
import com.wg.usuario.repositories.UsuarioRepository;
import com.wg.usuario.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioProducer usuarioProducer;
	
	public UsuarioRecordDto salvar(UsuarioRecordDto usuarioDto) {
		
		UsuarioModel novoUsuario = new UsuarioModel(usuarioDto);
		
		usuarioRepository.save(novoUsuario);
		
		usuarioProducer.publicMessageEmail(novoUsuario);
		
		
		
		return usuarioDto;
	}
	
	public List<UsuarioRecordDto> findAll(){
		
		List<UsuarioModel> usuarioModel = usuarioRepository.findAll();
		List<UsuarioRecordDto> usuarioDtos = new ArrayList<>();
		
		for(UsuarioModel model : usuarioModel) {
			var usuarioDto = new UsuarioRecordDto(model.getIdusuario(),model.getNome(),model.getEmail());
			usuarioDtos.add(usuarioDto);
		}
		
		return usuarioDtos;
	}
	
	public UsuarioRecordDto findById(String id) {
		
		Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
		
		usuario.orElseThrow(()-> new ResourceNotFoundException(id));
		
		var usuarioDto = new UsuarioRecordDto(usuario.get().getIdusuario(),usuario.get().getNome(),
				                              usuario.get().getEmail());
		
		return usuarioDto;
	}
	
	public List<UsuarioRecordDto> buscaPorNome(String name) {
		
		List<UsuarioModel> usuario = usuarioRepository.buscaPorNome(name);
		
		List<UsuarioRecordDto> usuarioDtos = new ArrayList<>();
		
		for(UsuarioModel model : usuario) {
			usuarioDtos.add(new UsuarioRecordDto(model.getIdusuario(),model.getNome(),
					            model.getEmail()));
		}
		
		return usuarioDtos;
	}
	
	public void delete(String idusuario) {
		
		try {
			UsuarioModel usuarioModel = usuarioRepository.getReferenceById(idusuario);
			if(usuarioModel ==  null) {
				throw new ResourceNotFoundException(idusuario);
			}
			else {
				usuarioRepository.deleteById(usuarioModel.getIdusuario());
			}
			
		}catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(idusuario);
		}
			
			
	}
	
	public UsuarioRecordDto update(String idusuario,UsuarioRecordDto usuarioDto) {
		
		try {
			
			UsuarioModel entity = usuarioRepository.getReferenceById(idusuario);
			updateData(entity, usuarioDto);
			
			usuarioRepository.save(entity);
			
			var dto = new UsuarioRecordDto(entity.getIdusuario(),entity.getNome(),entity.getEmail());
			return dto;
			
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idusuario);
		}
		
	}
	
	public UsuarioModel updateData(UsuarioModel entity,UsuarioRecordDto usuarioDto) {
		
		entity.setNome(usuarioDto.nome());
		entity.setEmail(usuarioDto.email());
		
		return entity;
	}

}
