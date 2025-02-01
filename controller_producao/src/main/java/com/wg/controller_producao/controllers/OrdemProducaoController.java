package com.wg.controller_producao.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wg.controller_producao.models.OrdemProducao;
import com.wg.controller_producao.services.OrdemProducaoService;

@RestController
@RequestMapping(value = "/ordemProducao")
public class OrdemProducaoController {
	
	@Autowired
	private OrdemProducaoService ordemProducaoService;
	
	@GetMapping
	public ResponseEntity<List<OrdemProducao>> findAll(){
		
		List<OrdemProducao> ordemProducao = ordemProducaoService.finAll();
		
		return ResponseEntity.ok().body(ordemProducao);
	}
	
	@GetMapping(value = "buscarPorIdPedido/{idpedido}")
	public ResponseEntity<List<OrdemProducao>> buscarPorIdPedido(@PathVariable String idpedido){
		
		List<OrdemProducao> ordemProducao = ordemProducaoService.buscarPorIdPedido(idpedido);
		
		return ResponseEntity.ok().body(ordemProducao);
	}
	
	@GetMapping(value = "buscarPorDataPedido/{datapedido}")
    public ResponseEntity<List<OrdemProducao>> buscarPorDataPedido(@PathVariable LocalDate datapedido){
    	
    	List<OrdemProducao> ordemProducao = ordemProducaoService.buscarPorDataPedido(datapedido);
    	
    	return ResponseEntity.ok().body(ordemProducao);
    }

}
