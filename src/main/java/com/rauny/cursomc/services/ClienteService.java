package com.rauny.cursomc.services;

import com.rauny.cursomc.domain.Categoria;
import com.rauny.cursomc.domain.Cliente;
import com.rauny.cursomc.repositories.CategoriaRepository;
import com.rauny.cursomc.repositories.ClienteRepository;
import com.rauny.cursomc.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obg = repo.findById(id);
		return obg.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}



