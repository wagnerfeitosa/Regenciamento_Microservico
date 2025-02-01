package com.wg.pedido.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {
	
	@Value("${broker.queue.produto.name}")
	private String queue;
	
	@Bean
	public Queue queue() {
		return new Queue(queue, true);
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverte() {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		return new Jackson2JsonMessageConverter(objectMapper);
	}
	

}
