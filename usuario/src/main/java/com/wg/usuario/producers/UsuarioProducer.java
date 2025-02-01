package com.wg.usuario.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wg.usuario.dtos.EmailDto;
import com.wg.usuario.models.UsuarioModel;

@Component
public class UsuarioProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value(value = "${broker.queue.email.name}")
	private String routingkey;
	
	public void publicMessageEmail(UsuarioModel usuarioModel) {
		
		var emailDto = new EmailDto();
		
		emailDto.setIdusuario(usuarioModel.getIdusuario());
		emailDto.setEmailTo(usuarioModel.getEmail());
		emailDto.setSubject("Cadastro realizado com sucesso");
		emailDto.setText(usuarioModel.getNome() + ",Seja bem vindo(a) ! agradecemos o seu cadastro");
		
		rabbitTemplate.convertAndSend("", routingkey,emailDto);
	}

}
