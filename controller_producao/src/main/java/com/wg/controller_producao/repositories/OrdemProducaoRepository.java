package com.wg.controller_producao.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wg.controller_producao.models.OrdemProducao;

public interface OrdemProducaoRepository extends JpaRepository<OrdemProducao, Long>{
	
	@Query(value = "select i from OrdemProducao i where i.idpedido = :idpedido")
	List<OrdemProducao> buscarPorIdPedido(String idpedido);
	
	@Query(value = "select d from OrdemProducao d where d.dataOrdem = :data")
	List<OrdemProducao> buscarPorDataOrdem(LocalDate data);

}
