package com.rauny.cursomc.services;

import com.rauny.cursomc.domain.Categoria;
import com.rauny.cursomc.domain.Pedido;
import com.rauny.cursomc.repositories.CategoriaRepository;
import com.rauny.cursomc.repositories.PedidoRepository;
import com.rauny.cursomc.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obg = repo.findById(id);
		return obg.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
