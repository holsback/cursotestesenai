package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.senai.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	//Jpa fará todo o servico de insert, delete, update, etc...
	//Veja que busca de cliente e o integer e que tipo do nosso id e integer
	//Veja que é uma interface que extende os recursos do jpa
}
