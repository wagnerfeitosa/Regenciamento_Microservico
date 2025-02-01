package com.wg.controller_producao.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wg.controller_producao.dtos.CbDto;
import com.wg.controller_producao.dtos.EmailDto;
import com.wg.controller_producao.dtos.UsuarioDto;
import com.wg.controller_producao.services.UsuarioServiceClient;

@Component
public class controller_producaoProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private UsuarioServiceClient serviceUsuario;
	

	
	@Value(value = "${broker.queue.email.name}")
	private String routingkeyEmail;
	
	public void publicMessageEmail(CbDto cbDto) {
		
		var usuarioDto = new UsuarioDto();
		usuarioDto = serviceUsuario.usuario(cbDto.getIdusuario());
		
		var emailDto = new EmailDto();
		emailDto.setIdusuario(usuarioDto.getIdusuario());
		emailDto.setEmailTo(usuarioDto.getEmail());
		emailDto.setSubject("Pedido em processo de produção");
		emailDto.setText(usuarioDto.getNome()+", Seu produto está no departamento de produção");
		
		rabbitTemplate.convertAndSend("",routingkeyEmail,emailDto);
		
		
		
		
	}

}
