package com.wg.controller_producao.models;

import java.io.Serializable;

public class Cb16mm extends CBAbstract implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nome = "FEIXE DE COBRE NU P/ CABO 16MM";
	private Integer formacao = 114;
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


	public void MQ1(Integer quantidade) {
		System.out.println("ORDEM DE PRODUÇÃO MQ1");
		this.passoMax = "181.1";
		this.passoMin = "26.1";
		this.direcao = "ESQUERDA";
		this.bobinaComFios_1 =  30;
		this.bobinaComFios_3 = (formacao - bobinaComFios_1) / 3;
		this.capacidadeBobina  = 12500;
		this.quantidade = quantidade;
		this.maquina = "MQ1";
		
		if(quantidade > capacidadeBobina) {
			this.qtCarga = quantidade / capacidadeBobina;
			this.qtBobina = quantidade / capacidadeBobina * 4;
			this.qtRestante = quantidade - (capacidadeBobina * qtCarga);
			
		}else {
			this.qtCarga = 1;
			this.qtBobina = 4;
		}
		
		
		
		
	}

}
