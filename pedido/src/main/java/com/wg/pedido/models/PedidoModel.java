package com.wg.pedido.models;

import java.io.Serializable;
import java.util.Objects;

import com.wg.pedido.dtos.PedidoRecordDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class PedidoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idpedido;
	private String idusuario;
	private String idproduto;
	private Integer quantidade;
	private Double valor;
	
	public PedidoModel() {}
	
	public PedidoModel(String idpedido,String idusuario,String idproduto,Integer quantidade,Double valor) {
		this.idpedido = idpedido;
		this.idusuario = idusuario;
		this.idproduto = idproduto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public PedidoModel(PedidoRecordDto pedidoDto) {
		this.idusuario = pedidoDto.idusuario();
		this.idproduto = pedidoDto.idproduto();
		this.quantidade = pedidoDto.quantidade();
		this.valor = pedidoDto.valor();
	}

	public String getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(String idproduto) {
		this.idproduto = idproduto;
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

	@Override
	public int hashCode() {
		return Objects.hash(idpedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoModel other = (PedidoModel) obj;
		return Objects.equals(idpedido, other.idpedido);
	}
	
	

}
