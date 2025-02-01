package com.wg.controller_producao.dtos;

public class CbDto {
	
	private String idusuario;
	private String idpedido;
	private String nomeProduto;
	private Integer quantidade;
	
	public String getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	

}
