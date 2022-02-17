package com.rauny.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rauny.cursomc.domain.Categoria;
import com.rauny.cursomc.domain.Cidade;
import com.rauny.cursomc.domain.Cliente;
import com.rauny.cursomc.domain.Endereco;
import com.rauny.cursomc.domain.Estado;
import com.rauny.cursomc.domain.Produto;
import com.rauny.cursomc.domain.enums.TipoCliente;
import com.rauny.cursomc.repositories.CategoriaRepository;
import com.rauny.cursomc.repositories.CidadeRepository;
import com.rauny.cursomc.repositories.ClienteRepository;
import com.rauny.cursomc.repositories.EnderecoRepository;
import com.rauny.cursomc.repositories.EstadoRepository;
import com.rauny.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impresora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "MG");
		Estado est2 = new Estado(null, "SP");
		
		Cidade c1 = new Cidade(null, "CG", est1);
		Cidade c2 = new Cidade(null, "MCZ", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria", "maria@email.com", "16788305005", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("32991470743", "95985211340"));
		
		Endereco e1 = new Endereco(null, "Top", "300", "Apt 300", "Jardim", "69316498", cli1, c1);
		Endereco e2 = new Endereco(null, "Topper", "800", "Apt 800", "Jardim", "69017192", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
