package com.wg.pedido.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wg.pedido.dtos.PedidoRelatorioDto;
import com.wg.pedido.dtos.PedidoRecordDto;
import com.wg.pedido.models.PedidoModel;
import com.wg.pedido.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<PedidoRecordDto>> findAll(){
		
		List<PedidoRecordDto> pedidos = pedidoService.findAll();
		
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "consultar/{idpedido}")
	public ResponseEntity<PedidoRelatorioDto> getPedido(@PathVariable String idpedido){
		
		return ResponseEntity.ok().body(pedidoService.getPedido(idpedido));
		
	}
	 
	@PostMapping
	public ResponseEntity<PedidoModel> salvar(@RequestBody PedidoRecordDto pedidoDto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvar(pedidoDto));
	}

}
