package com.wg.pedido.dtos;

import jakarta.validation.constraints.NotBlank;

public record PedidoRecordDto(@NotBlank String idpedido,
		                      @NotBlank String idusuario,
		                      @NotBlank String idproduto,
		                      @NotBlank Integer quantidade,
		                      @NotBlank Double valor) {

}
