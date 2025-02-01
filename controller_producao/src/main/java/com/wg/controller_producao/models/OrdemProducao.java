package com.wg.controller_producao.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ordem_producao")
public class OrdemProducao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idordemProducao;
	private String idpedido;
	private String nome;
	private Integer formacao;
	private String passoMax;
	private String passoMin;
	private String direcao;
	private Integer bobinaComFios_1;
	private Integer bobinaComFios_3;
	private Integer capacidadeBobina;
	private Integer quantidade;
	private Integer qtCarga;
	private Integer qtBobina;
	private Integer qtRestante;
	private String maquina;
	private LocalDate dataOrdem;
	
	
	
	public LocalDate getDataOrdem() {
		return dataOrdem;
	}
	public void setDataOrdem(LocalDate dataOrdem) {
		this.dataOrdem = dataOrdem;
	}
	public Long getIdordemProducao() {
		return idordemProducao;
	}
	public void setIdordemProducao(Long idordemProducao) {
		this.idordemProducao = idordemProducao;
	}
	public String getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getFormacao() {
		return formacao;
	}
	public void setFormacao(Integer formacao) {
		this.formacao = formacao;
	}
	public String getPassoMax() {
		return passoMax;
	}
	public void setPassoMax(String passoMax) {
		this.passoMax = passoMax;
	}
	public String getPassoMin() {
		return passoMin;
	}
	public void setPassoMin(String passoMin) {
		this.passoMin = passoMin;
	}
	public String getDirecao() {
		return direcao;
	}
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	public Integer getBobinaComFios_1() {
		return bobinaComFios_1;
	}
	public void setBobinaComFios_1(Integer bobinaComFios_1) {
		this.bobinaComFios_1 = bobinaComFios_1;
	}
	public Integer getBobinaComFios_3() {
		return bobinaComFios_3;
	}
	public void setBobinaComFios_3(Integer bobinaComFios_3) {
		this.bobinaComFios_3 = bobinaComFios_3;
	}
	public Integer getCapacidadeBobina() {
		return capacidadeBobina;
	}
	public void setCapacidadeBobina(Integer capacidadeBobina) {
		this.capacidadeBobina = capacidadeBobina;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Integer getQtCarga() {
		return qtCarga;
	}
	public void setQtCarga(Integer qtCarga) {
		this.qtCarga = qtCarga;
	}
	public Integer getQtBobina() {
		return qtBobina;
	}
	public void setQtBobina(Integer qtBobina) {
		this.qtBobina = qtBobina;
	}
	public Integer getQtRestante() {
		return qtRestante;
	}
	public void setQtRestante(Integer qtRestante) {
		this.qtRestante = qtRestante;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idordemProducao);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemProducao other = (OrdemProducao) obj;
		return Objects.equals(idordemProducao, other.idordemProducao);
	}
	
	

}
