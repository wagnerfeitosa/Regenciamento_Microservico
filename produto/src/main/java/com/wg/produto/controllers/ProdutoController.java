package com.wg.produto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wg.produto.dtos.ProdutoRecordDto;
import com.wg.produto.models.ProdutoModel;
import com.wg.produto.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@PostMapping
	public ResponseEntity<ProdutoRecordDto> salvar(@RequestBody ProdutoRecordDto produtoDto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(produtoDto));
		
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoRecordDto>> findAll(){
		
		List<ProdutoRecordDto> produtos = produtoService.findAll();
		
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping(value = "/{idproduto}")
	public ResponseEntity<ProdutoRecordDto> findById(@PathVariable String idproduto){
		
		return ResponseEntity.ok().body(produtoService.findById(idproduto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		
		produtoService.delete(id);
		
		return ResponseEntity.noContent().build();
		
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoRecordDto> update(@PathVariable String id,@RequestBody ProdutoRecordDto produtoDto) {
		
		
		return ResponseEntity.ok().body(produtoService.update(id, produtoDto));
	}
	
	

}
