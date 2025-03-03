package com.wg.controller_producao.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.controller_producao.dtos.CbDto;
import com.wg.controller_producao.models.CBAbstract;
import com.wg.controller_producao.models.ListaCb;
import com.wg.controller_producao.models.OrdemProducao;
import com.wg.controller_producao.producers.controller_producaoProducer;
import com.wg.controller_producao.repositories.OrdemProducaoRepository;
import com.wg.controller_producao.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrdemProducaoService {
	
	@Autowired
	private OrdemProducaoRepository ordemProducaoRepository;
	
	@Autowired
	private controller_producaoProducer producer;
	
	
	public OrdemProducao ordemProducao(CbDto cbDto) {
		
		ListaCb.iniciar();
		CBAbstract cb = ListaCb.getInstanciaCb(cbDto.getNomeProduto());
		cb.MQ1(cbDto.getQuantidade());
		
		OrdemProducao ordem = new OrdemProducao();
		ordem.setIdpedido(cbDto.getIdpedido());
		ordem.setNome(cb.getNome());
		ordem.setFormacao(cb.getFormacao());
		ordem.setDirecao(cb.getDirecao());
		ordem.setBobinaComFios_1(cb.getBobinaComFios_1());
		ordem.setBobinaComFios_3(cb.getBobinaComFios_3());
		ordem.setCapacidadeBobina(cb.getCapacidadeBobina());
		ordem.setPassoMax(cb.getPassoMax());
		ordem.setMaquina(cb.getMaquina());
		ordem.setDataOrdem(LocalDate.now());
		ordem.setQtCarga(cb.getQtCarga());
		ordem.setQtBobina(cb.getQtBobina());
		ordem.setQtRestante(cb.getQtRestante());
		ordem.setQuantidade(cb.getQuantidade());
		
		
		
		ordemProducaoRepository.save(ordem);
		
		producer.publicMessageEmail(cbDto);		
		
		return ordem;
		
		
	}
	
	public List<OrdemProducao> finAll(){
		
		return ordemProducaoRepository.findAll();
	}
	
	public List<OrdemProducao> buscarPorIdPedido(String idpedido) {
		
		return ordemProducaoRepository.buscarPorIdPedido(idpedido);
		
	}
	
	public List<OrdemProducao> buscarPorDataPedido(LocalDate datapedido){
		
		return ordemProducaoRepository.buscarPorDataOrdem(datapedido);
		
	
	}
	
	
	

}
