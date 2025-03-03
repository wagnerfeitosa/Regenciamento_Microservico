package com.wg.produto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.produto.dtos.ProdutoRecordDto;
import com.wg.produto.models.ProdutoModel;
import com.wg.produto.repositories.ProdutoRepository;
import com.wg.produto.service.exceptios.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoRecordDto salvar(ProdutoRecordDto produtoDto) {
		
		ProdutoModel novoProduto = new ProdutoModel(produtoDto);
		
		produtoRepository.save(novoProduto);
		
		return produtoDto;
	}
	
	public List<ProdutoRecordDto> findAll(){
		
		List<ProdutoModel> produtos = produtoRepository.findAll();
		List<ProdutoRecordDto> produtoDtos = new ArrayList<>();
		
		for(ProdutoModel model : produtos) {
			produtoDtos.add(new ProdutoRecordDto(model.getIdproduto(),model.getNome(),model.getValor()));
		}
		
		return produtoDtos;
	}
	
	public ProdutoRecordDto findById(String idproduto) {
		
		Optional<ProdutoModel> produto = produtoRepository.findById(idproduto);
		produto.orElseThrow(()-> new ResourceNotFoundException(idproduto));
		
		var produtoDto =  new ProdutoRecordDto(produto.get().getIdproduto(),produto.get().getNome(),
				                               produto.get().getValor());
		
		return produtoDto;
		
		
	}
	
	public void delete(String id) {
		
		ProdutoModel produto = produtoRepository.getReferenceById(id);
		if(produto.getIdproduto().isEmpty()) {
			throw new ResourceNotFoundException(id);
		}else {
			produtoRepository.deleteById(id);
		}
	}
	
	public ProdutoRecordDto update(String id,ProdutoRecordDto produtoDto) {
		
		try {
			ProdutoModel produtoEntity = produtoRepository.getReferenceById(id);
			updateData(produtoEntity, produtoDto);
			
			produtoRepository.save(produtoEntity);
			
			
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
			
		}
		return produtoDto;
		
	}
	public ProdutoModel updateData(ProdutoModel entity,ProdutoRecordDto produtoDto) {
		
		entity.setNome(produtoDto.nome());
		entity.setValor(produtoDto.valor());
		
		return entity;
	}

}
