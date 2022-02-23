package com.rauny.cursomc.repositories;

import com.rauny.cursomc.domain.Pagamento;
import com.rauny.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
	
	

}
