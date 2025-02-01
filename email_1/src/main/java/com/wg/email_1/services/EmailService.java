package com.wg.email_1.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wg.email_1.models.EmailModel;
import com.wg.email_1.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Value(value ="${spring.mail.username}")
	private String emailFrom;
	
	
	public EmailModel senderEmail(EmailModel emailModel) {
		
		try {
			
			emailModel.setSendDataEmail(LocalDateTime.now());
			emailModel.setEmailFrom(emailFrom);
			
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			
			emailSender.send(message);
			
		}catch(MailException  e) {
			e.printStackTrace();
			
		}
		
		return emailRepository.save(emailModel);
		
		
		
	}

}
