package com.bruno.senai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.senai.domain.Cliente;
import com.bruno.senai.repositories.ClienteRepository;
import com.bruno.senai.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	//Veja que está instanciando de repository que tem dml
	//repo - abaixo - é o objeto criado
	@Autowired
	private ClienteRepository repo;
	
	//Metodo que faz a busca de cliente
	public Cliente buscar(Integer idCliente) {
		Optional<Cliente> obj = repo.findById(idCliente);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Número de id não encontrado. Id: " + idCliente + ", tipo: "
				+ Cliente.class.getCanonicalName()));
		
	}
}
