package com.wg.usuario.models;

import java.io.Serializable;
import java.util.Objects;

import com.wg.usuario.dtos.UsuarioRecordDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idusuario;
	private String nome;
	private String email;
	
	public UsuarioModel() {}
	
	public UsuarioModel(String idusuario,String nome,String email) {
		this.idusuario = idusuario;
		this.nome = nome;
		this.email = email;
	}
	
	public UsuarioModel(UsuarioRecordDto usuarioDto) {
		this.nome = usuarioDto.nome();
		this.email = usuarioDto.email();
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idusuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioModel other = (UsuarioModel) obj;
		return Objects.equals(idusuario, other.idusuario);
	}
	
	

}
