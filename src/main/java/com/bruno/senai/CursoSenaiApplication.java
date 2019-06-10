package com.bruno.senai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.senai.domain.Cliente;
import com.bruno.senai.domain.Estado;
import com.bruno.senai.domain.enuns.TipoCliente;
import com.bruno.senai.repositories.ClienteRepository;
import com.bruno.senai.repositories.EstadoRepository;

import java.util.Arrays;

@SpringBootApplication
public class CursoSenaiApplication implements CommandLineRunner {
	// Uma dependencia para instanciar todo o objeto
	@Autowired
	private EstadoRepository estadoRepository2;

	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSenaiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instancio estado e preencho
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		// Foi chamado acima e aqui salva
		estadoRepository2.saveAll(Arrays.asList(est1, est2));
	
	Cliente cli1 = new Cliente(null, "Ana Laura", "12345678987", "ana@gmail.com", TipoCliente.PESSOAFISICA);
	cli1.getTelefones().addAll(Arrays.asList("34000000301", "340000041001"));
	clienteRepository.saveAll(Arrays.asList(cli1));
	
	Cliente cli2 = new Cliente(null, "Ana Julia", "12345678986", "laura@gmail.com", TipoCliente.PESSOAFISICA);
	cli2.getTelefones().addAll(Arrays.asList("34000000010", "34000000011"));
	clienteRepository.saveAll(Arrays.asList(cli2));
	
	Cliente cli3 = new Cliente(null, "Anna Laura", "12345678985", "anna@gmail.com", TipoCliente.PESSOAFISICA);
	cli3.getTelefones().addAll(Arrays.asList("34000000012", "34000000013"));
	clienteRepository.saveAll(Arrays.asList(cli3));
	
	Cliente cli4 = new Cliente(null, "Bruno H", "12345678984", "bruno@gmail.com", TipoCliente.PESSOAFISICA);
	cli4.getTelefones().addAll(Arrays.asList("34000000014", "34000000015"));
	clienteRepository.saveAll(Arrays.asList(cli4));
	
	Cliente cli5 = new Cliente(null, "Pedro", "12345678912", "pedro@gmail.com", TipoCliente.PESSOAFISICA);
	cli5.getTelefones().addAll(Arrays.asList("34000000016", "34000000017"));
	clienteRepository.saveAll(Arrays.asList(cli5));
	
	Cliente cli6 = new Cliente(null, "Breno H", "12345678456", "breno@gmail.com", TipoCliente.PESSOAFISICA);
	cli6.getTelefones().addAll(Arrays.asList("34000000018", "34000000019"));
	clienteRepository.saveAll(Arrays.asList(cli6));
	
	Cliente cli7 = new Cliente(null, "Joao", "98345678987", "joao@gmail.com", TipoCliente.PESSOAFISICA);
	cli7.getTelefones().addAll(Arrays.asList("34000006700", "34010000001"));
	clienteRepository.saveAll(Arrays.asList(cli7));
	
	Cliente cli8 = new Cliente(null, "Pietra", "12265678987", "pietra@gmail.com", TipoCliente.PESSOAFISICA);
	cli8.getTelefones().addAll(Arrays.asList("34000926000", "34000916501"));
	clienteRepository.saveAll(Arrays.asList(cli8));
	
	Cliente cli9 = new Cliente(null, "Augusto", "12028678987", "aug@gmail.com", TipoCliente.PESSOAFISICA);
	cli9.getTelefones().addAll(Arrays.asList("34000000000", "34000500001"));
	clienteRepository.saveAll(Arrays.asList(cli9));
	
	Cliente cli10 = new Cliente(null, "Luis", "12345652087", "luis@gmail.com", TipoCliente.PESSOAFISICA);
	cli10.getTelefones().addAll(Arrays.asList("34000000000", "30482000001"));
	clienteRepository.saveAll(Arrays.asList(cli10));

	}
}
