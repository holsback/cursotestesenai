package com.bruno.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.senai.domain.Cidade;

@Repository
public interface  CidadeRepository extends JpaRepository<Cidade, Integer> {

}
