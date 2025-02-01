package com.wg.produto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wg.produto.models.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, String>{

}
