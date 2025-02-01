package com.wg.email_1.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_email")
public class EmailModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String emailId;
	private String idusuario;
	private String emailFrom;
	private String emailTo;
	private String subject;
	
	//definindo para ser um tipo TEXT na base de dados para guardar mais dados
	@Column(columnDefinition = "TEXT")
	private String text;
	private LocalDateTime sendDataEmail;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getSendDataEmail() {
		return sendDataEmail;
	}
	public void setSendDataEmail(LocalDateTime sendDataEmail) {
		this.sendDataEmail = sendDataEmail;
	}
	
	
	


}
