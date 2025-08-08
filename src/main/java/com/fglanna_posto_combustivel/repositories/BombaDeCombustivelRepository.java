package com.fglanna_posto_combustivel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fglanna_posto_combustivel.entities.BombasDeCombustivel;

public interface BombaDeCombustivelRepository extends JpaRepository<BombasDeCombustivel, Integer> {	
	

}
