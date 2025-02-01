package com.wg.produto.models;

import java.io.Serializable;
import java.util.Objects;

import com.wg.produto.dtos.ProdutoRecordDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idproduto;
	private String nome;
	private Double valor;
	
	public ProdutoModel() {}
	
	public ProdutoModel(String idproduto,String nome,Double valor) {
		this.idproduto = idproduto;
		this.nome = nome;
		this.valor = valor;
	}
	
	public ProdutoModel(ProdutoRecordDto produtoDto) {
		this.nome = produtoDto.nome();
		this.valor = produtoDto.valor();
	}

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idproduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoModel other = (ProdutoModel) obj;
		return Objects.equals(idproduto, other.idproduto);
	}
	
	

}
