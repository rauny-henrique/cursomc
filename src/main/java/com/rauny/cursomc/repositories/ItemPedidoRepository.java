package com.rauny.cursomc.repositories;

import com.rauny.cursomc.domain.ItemPedido;
import com.rauny.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
	
	

}
