package com.bruno.senai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.senai.domain.Estado;
import com.bruno.senai.repositories.EstadoRepository;

import java.util.Arrays;

@SpringBootApplication
public class CursoSenaiApplication implements CommandLineRunner {
	// Uma dependencia para instanciar todo o objeto
	@Autowired
	private EstadoRepository estadoRepository2;

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
		}
}
