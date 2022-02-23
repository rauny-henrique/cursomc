package com.rauny.cursomc.repositories;

import com.rauny.cursomc.domain.Categoria;
import com.rauny.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	

}
