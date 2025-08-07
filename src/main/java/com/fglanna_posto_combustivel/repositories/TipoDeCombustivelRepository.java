package com.fglanna_posto_combustivel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fglanna_posto_combustivel.entities.TiposDeCombustivel;

public interface TipoDeCombustivelRepository extends JpaRepository<TiposDeCombustivel, Integer> {
	
	

}
