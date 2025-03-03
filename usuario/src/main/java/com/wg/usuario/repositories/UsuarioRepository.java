package com.wg.usuario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wg.usuario.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, String>{
	
	@Query(value = "select u from UsuarioModel u where u.nome like%?1%")
	List<UsuarioModel> buscaPorNome(String name);

}
