package com.bruno.senai;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.senai.domain.Cidade;
import com.bruno.senai.domain.Cliente;
import com.bruno.senai.domain.Endereco;
import com.bruno.senai.domain.Estado;
import com.bruno.senai.domain.enuns.TipoCliente;
import com.bruno.senai.repositories.CidadeRepository;
import com.bruno.senai.repositories.ClienteRepository;
import com.bruno.senai.repositories.EnderecoRepository;
import com.bruno.senai.repositories.EstadoRepository;

@SpringBootApplication
public class CursoSenaiApplication implements CommandLineRunner {
	// Uma dependencia para instanciar todo o objeto
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSenaiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instancio estado e preencho
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		// Foi chamado acima e aqui salva
		
		Estado est3 = new Estado(null, "Rio de Janeiro");
        Estado est4 = new Estado(null, "Rio Grande do Sul");
        Estado est5 = new Estado(null, "Santa Catarina");
        Estado est6 = new Estado(null, "Mato Grosso");
        Estado est7 = new Estado(null, "Mato Grosso do Sul");
        Estado est8 = new Estado(null, "Acre");
        Estado est9 = new Estado(null, "Amazonas");
        Estado est10 = new Estado(null, "Pernambuco");
        estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, est9, est10));
        
        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Rio de Janeiro", est3);
        Cidade c4 = new Cidade(null, "Porto Alegre", est4);
        Cidade c5 = new Cidade(null, "Florianópolis", est5);
        Cidade c6 = new Cidade(null, "Cuiabá", est6);
        Cidade c7 = new Cidade(null, "Corumbá", est7);
        Cidade c8 = new Cidade(null, "Rio Branco", est8);
        Cidade c9 = new Cidade(null, "Manaus", est9);
        Cidade c10 = new Cidade(null, "Recife", est10);
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
        

        
        
		Cliente cli1 = new Cliente(null, "Ana Laura", "12345678987", "ana@gmail.com", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("34000000301", "340000041001"));
		

		Cliente cli2 = new Cliente(null, "Ana Julia", "12345678986", "laura@gmail.com", TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("34000000010", "34000000011"));
		

		Cliente cli3 = new Cliente(null, "Anna Laura", "12345678985", "anna@gmail.com", TipoCliente.PESSOAFISICA);
		cli3.getTelefones().addAll(Arrays.asList("34000000012", "34000000013"));
		

		Cliente cli4 = new Cliente(null, "Bruno H", "12345678984", "bruno@gmail.com", TipoCliente.PESSOAFISICA);
		cli4.getTelefones().addAll(Arrays.asList("34000000014", "34000000015"));
		

		Cliente cli5 = new Cliente(null, "Pedro", "12345678912", "pedro@gmail.com", TipoCliente.PESSOAFISICA);
		cli5.getTelefones().addAll(Arrays.asList("34000000016", "34000000017"));
		

		Cliente cli6 = new Cliente(null, "Breno H", "12345678456", "breno@gmail.com", TipoCliente.PESSOAFISICA);
		cli6.getTelefones().addAll(Arrays.asList("34000000018", "34000000019"));
		

		Cliente cli7 = new Cliente(null, "Joao", "98345678987", "joao@gmail.com", TipoCliente.PESSOAFISICA);
		cli7.getTelefones().addAll(Arrays.asList("34000006700", "34010000001"));
		

		Cliente cli8 = new Cliente(null, "Pietra", "12265678987", "pietra@gmail.com", TipoCliente.PESSOAFISICA);
		cli8.getTelefones().addAll(Arrays.asList("34000926000", "34000916501"));
		

		Cliente cli9 = new Cliente(null, "Augusto", "12028678987", "aug@gmail.com", TipoCliente.PESSOAFISICA);
		cli9.getTelefones().addAll(Arrays.asList("34000000000", "34000500001"));
		

		Cliente cli10 = new Cliente(null, "Luis", "12345652087", "luis@gmail.com", TipoCliente.PESSOAFISICA);
		cli10.getTelefones().addAll(Arrays.asList("34000000000", "30482000001"));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6, cli7, cli8, cli9, cli10));
        
		Endereco e1 = new Endereco(null, "Rua Marte", "12", "Ap 30", "centro", "38401537", cli1, c1);
        Endereco e2 = new Endereco(null, "Rua Terra", "13", null, "Alameda", "38402537", cli2, c2);
        Endereco e3 = new Endereco(null, "Rua Júpiter", "14", null, "Pacaembu", "38403537", cli3, c3);
        Endereco e4 = new Endereco(null, "Rua EUA", "15", null, "Granada", "39504537", cli4, c4);
        Endereco e5 = new Endereco(null, "Rua Inglaterra", "16", null, "Roosevelt", "38402357", cli5, c5);
        Endereco e6 = new Endereco(null, "Rua Caio", "17", "Ap 40", "Centro", "39041309", cli6, c6);
        Endereco e7 = new Endereco(null, "Rua Pedro", "18", null, "Augusto", "38209301", cli7, c7);
        Endereco e8 = new Endereco(null, "Rua Edim", "19", null, "Joao", "94789011", cli8, c8);
        Endereco e9 = new Endereco(null, "Rua Peteca", "20", null, "Caio", "87567029", cli9, c9);
        Endereco e10 = new Endereco(null, "Rua Primim", "21", "Ap 2", "Guilherme", "98560617", cli10, c10);
        
        cli1.getEnderecos().addAll(Arrays.asList(e1));
        cli2.getEnderecos().addAll(Arrays.asList(e2));
        cli3.getEnderecos().addAll(Arrays.asList(e3));
        cli4.getEnderecos().addAll(Arrays.asList(e4));
        cli5.getEnderecos().addAll(Arrays.asList(e5));
        cli6.getEnderecos().addAll(Arrays.asList(e6));
        cli7.getEnderecos().addAll(Arrays.asList(e7));
        cli8.getEnderecos().addAll(Arrays.asList(e8));
        cli9.getEnderecos().addAll(Arrays.asList(e9));
        cli10.getEnderecos().addAll(Arrays.asList(e10));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));
        
	}
}
