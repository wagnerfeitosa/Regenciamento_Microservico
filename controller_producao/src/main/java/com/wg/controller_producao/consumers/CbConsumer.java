package com.wg.controller_producao.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.wg.controller_producao.dtos.CbDto;
import com.wg.controller_producao.producers.controller_producaoProducer;
import com.wg.controller_producao.services.OrdemProducaoService;

@Component
public class CbConsumer {
	
	
	@Autowired
	private OrdemProducaoService ordemService;
	
	
	@RabbitListener(queues = "${broker.queue.produto.name}")
	public  void ListenerMessageProduto(@Payload CbDto cbDto) {
		
		
		
	ordemService.ordemProducao(cbDto);
	
	

		
		
	
		
		
	}

}
