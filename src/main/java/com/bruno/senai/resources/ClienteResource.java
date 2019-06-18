package com.bruno.senai.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bruno.senai.domain.Cliente;
import com.bruno.senai.services.ClienteService;

@RestController // para serem serializados e transformados em json ou xml
@RequestMapping(value = "/clientes") // caminho que será encontrado
public class ClienteResource {
	// buscando os métodos que estão em Cliente service
	@Autowired // faz a instanciacao sem precisar do new
	private ClienteService service;

	// neste request pediremos o id do cliente
	// method requesitado é o get
	// resposta da entidade será em cliente em domain
	// find para encontrar
	// @PathVariable - o valor vira da url
	// obj - service (ClienteService metodo buscar)
	// Retorna no corpo do objeto todas as informacoes
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Cliente obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
		return ResponseEntity.created(uri).build();
	}

	public ClienteService getService() {
		return service;
	}

	public void setService(ClienteService service) {
		this.service = service;
	}

}
