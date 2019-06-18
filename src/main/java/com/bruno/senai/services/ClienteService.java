package com.bruno.senai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.senai.domain.Cliente;
import com.bruno.senai.repositories.ClienteRepository;
import com.bruno.senai.repositories.EnderecoRepository;
import com.bruno.senai.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	// Veja que está instanciando de repository que tem dml
	// repo - abaixo - é o objeto criado
	@Autowired
	private ClienteRepository repo;

	@Autowired
	private EnderecoRepository enderecoRepository;

	// Metodo que faz a busca de cliente
	public Cliente buscar(Integer idCliente) {
		Optional<Cliente> obj = repo.findById(idCliente);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Número de id não encontrado. Id: " + idCliente + ", tipo: " + Cliente.class.getCanonicalName()));
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	
	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public ClienteRepository getRepo() {
		return repo;
	}

	public void setRepo(ClienteRepository repo) {
		this.repo = repo;
	}

	public EnderecoRepository getEnderecoRepository() {
		return enderecoRepository;
	}

	public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

}
