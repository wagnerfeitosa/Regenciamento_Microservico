package com.wg.pedido.dtos;

public class UsuarioDto {
	
	private String idusuario;
	private String nome;
	private String email;
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
	public String toString() {
		return "UsuarioDto [idusuario=" + idusuario + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
	

}
