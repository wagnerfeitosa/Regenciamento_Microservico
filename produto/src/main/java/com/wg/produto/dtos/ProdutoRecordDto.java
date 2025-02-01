package com.wg.produto.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProdutoRecordDto(String idproduto,
		                      @NotBlank String nome,
		                      @NotBlank Double valor) {

}
