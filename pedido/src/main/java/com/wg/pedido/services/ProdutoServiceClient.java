package com.wg.pedido.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wg.pedido.dtos.ProdutoDto;

@FeignClient(name = "prosuto-service", url = "http://localhost:8082/produtos")
public interface ProdutoServiceClient {
	
	@GetMapping(value = "/{idproduto}")
	ProdutoDto produto (@PathVariable("idproduto") String idproduto);

}
