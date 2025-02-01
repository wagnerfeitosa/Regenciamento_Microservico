package com.wg.usuario.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDto(String idsuario,
		                       @NotBlank String nome,
		                       @NotBlank @Email String email) {
	

}
