package com.wg.email_1.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.wg.email_1.dtos.EmailDto;
import com.wg.email_1.models.EmailModel;
import com.wg.email_1.services.EmailService;

@Component
public class EmailConsumer {
	
	@Autowired
	private EmailService emailService;
	
	
	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenerMessageEmail(@Payload EmailDto emailDto) {
		
		var emailModel = new EmailModel();
		
		BeanUtils.copyProperties(emailDto, emailModel);
		
		emailService.senderEmail(emailModel);
		
		
	}

}
