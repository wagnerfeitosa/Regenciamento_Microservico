package com.wg.pedido.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.pedido.dtos.PedidoRecordDto;
import com.wg.pedido.dtos.PedidoRelatorioDto;
import com.wg.pedido.dtos.ProdutoDto;
import com.wg.pedido.dtos.UsuarioDto;
import com.wg.pedido.models.PedidoModel;
import com.wg.pedido.producers.PedidoProducer;
import com.wg.pedido.repositories.PedidoRepository;
import com.wg.pedido.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UsuarioServiceClient usuarioServiceCliente;
	
	@Autowired
	private ProdutoServiceClient produtoServiceCliente;
	
	@Autowired
	private PedidoProducer pedidoProducer;
	
	public List<PedidoRecordDto> findAll(){
		
		List<PedidoModel> pedidoModel = pedidoRepository.findAll();
		List<PedidoRecordDto> pedidoDtos = new ArrayList<>();
		
		for(PedidoModel model : pedidoModel) {
			pedidoDtos.add(new PedidoRecordDto(model.getIdpedido(),model.getIdusuario(),
					          model.getIdproduto(), model.getQuantidade(),model.getValor()));
		}
		
		return pedidoDtos;
	}
	
	public PedidoRelatorioDto getPedido(String idpedido){
		
		try {
			PedidoModel pedidoModel = pedidoRepository.getReferenceById(idpedido);
			String idusuario = pedidoModel.getIdusuario();
			String idproduto = pedidoModel.getIdproduto();
			
			var usuarioDto = new UsuarioDto();
			usuarioDto = getUsuario(idusuario);
			
			var produtoDto = new ProdutoDto();
			produtoDto = getProduto(idproduto);
			
			var pedidoDto = new PedidoRelatorioDto();
			pedidoDto.setIdpedido(pedidoModel.getIdpedido());
			pedidoDto.setQuantidade(pedidoModel.getQuantidade());
			pedidoDto.setValor(pedidoModel.getValor());
			pedidoDto.setIdusuario(usuarioDto.getIdusuario());
			pedidoDto.setNomeUsuario(usuarioDto.getNome());
			pedidoDto.setEmailUsuario(usuarioDto.getEmail());
			pedidoDto.setIdproduto(produtoDto.getIdproduto());
			pedidoDto.setNomeProduto(produtoDto.getNome());
			
			return pedidoDto;
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idpedido);
			
			
		}
				
	}
	
	public UsuarioDto getUsuario(String idusuario) {
		
		return usuarioServiceCliente.usuario(idusuario);
	}
	
	public ProdutoDto getProduto(String idproduto) {
		
		return produtoServiceCliente.produto(idproduto);
	}
	
	
	public PedidoModel salvar(PedidoRecordDto pedidoDto) {
		
		PedidoModel novoPedido = new PedidoModel(pedidoDto);
		pedidoRepository.save(novoPedido);
		
		pedidoProducer.publicMessagePedido(novoPedido);
		
		return novoPedido;
	}

}
