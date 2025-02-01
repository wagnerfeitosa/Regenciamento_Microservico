package com.wg.pedido.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wg.pedido.dtos.CBDto;
import com.wg.pedido.dtos.EmailDto;
import com.wg.pedido.dtos.ProdutoDto;
import com.wg.pedido.dtos.UsuarioDto;
import com.wg.pedido.models.PedidoModel;
import com.wg.pedido.services.ProdutoServiceClient;
import com.wg.pedido.services.UsuarioServiceClient;

@Component
public class PedidoProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ProdutoServiceClient produtoServiceCliente;
	
	@Autowired
	private UsuarioServiceClient usuarioServiceCliente;
	
	
	
	@Value(value = "${broker.queue.produto.name}")
	private String routingkey;
	
	@Value(value = "${broker.queue.email.name}")
	private String routingkeyEmail;
	

	
	public void publicMessagePedido(PedidoModel pedidoModel) {
		
		ProdutoDto produtoDto = produtoServiceCliente.produto(pedidoModel.getIdproduto());
		UsuarioDto usuarioDto = usuarioServiceCliente.usuario(pedidoModel.getIdusuario());
		
		var cbDto = new CBDto();
		cbDto.setIdusuario(pedidoModel.getIdusuario());
		cbDto.setIdpedido(pedidoModel.getIdpedido());
		cbDto.setNomeProduto(produtoDto.getNome());
		cbDto.setQuantidade(pedidoModel.getQuantidade());
		
		var emailDto = new EmailDto();
		emailDto.setIdusuario(usuarioDto.getIdusuario());
		emailDto.setEmailTo(usuarioDto.getEmail());
		emailDto.setSubject("Pedido realizado com sucesso!");
		emailDto.setText(usuarioDto.getNome() + ", Seu pedido foi realizado e logo estará em produção");
		
		
		rabbitTemplate.convertAndSend("",routingkey,cbDto);
		rabbitTemplate.convertAndSend("",routingkeyEmail,emailDto);
	}

}
