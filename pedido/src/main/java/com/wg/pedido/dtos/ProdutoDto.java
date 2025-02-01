package com.wg.pedido.dtos;

public class ProdutoDto {
	
	private String idproduto;
	private String nome;
	public String getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(String idproduto) {
		this.idproduto = idproduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "ProdutoDto [idproduto=" + idproduto + ", nome=" + nome + "]";
	}
	
	

}
