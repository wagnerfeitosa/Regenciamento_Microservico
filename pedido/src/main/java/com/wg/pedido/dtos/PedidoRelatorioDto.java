package com.wg.pedido.dtos;

public class PedidoRelatorioDto {
	
	private String idpedido;
	private Integer quantidade;
	private Double valor;
	
	private String idusuario;
	private String nomeUsuario;
	private String emailUsuario;
	
	private String idproduto;
	private String nomeProduto;
	public String getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(String idproduto) {
		this.idproduto = idproduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	
	

}
