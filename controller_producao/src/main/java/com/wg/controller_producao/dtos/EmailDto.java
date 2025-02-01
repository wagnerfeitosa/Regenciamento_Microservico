package com.wg.controller_producao.dtos;

public class EmailDto {
	
	private String idusuario;
	private String EmailTo;
	private String subject;
	private String text;
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getEmailTo() {
		return EmailTo;
	}
	public void setEmailTo(String emailTo) {
		EmailTo = emailTo;
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
	
	

}
