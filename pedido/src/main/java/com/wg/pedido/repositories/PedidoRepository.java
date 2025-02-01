package com.wg.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wg.pedido.models.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, String>{

}
