package com.fglanna_posto_combustivel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fglanna_posto_combustivel.entities.BombasDeCombustivel;
import com.fglanna_posto_combustivel.repositories.BombaDeCombustivelRepository;

import jakarta.transaction.Transactional;

@Service
public class BombaDeCombustivelService {
	
	private final BombaDeCombustivelRepository bombaDeCombustivelRepository;
	
	public BombaDeCombustivelService(BombaDeCombustivelRepository bombaDeCombustivelRepository) {
	        this.bombaDeCombustivelRepository = bombaDeCombustivelRepository;
	    }
	
	public void criar(BombasDeCombustivel bombasDeCombustivel) {
		bombaDeCombustivelRepository.save(bombasDeCombustivel);
		
	}
	
	public BombasDeCombustivel buscarBombasDeCombustivelporId(Integer id) {
		return bombaDeCombustivelRepository.findById(id).orElseThrow(() -> new NullPointerException("Bomba de Combustível Inexistente conforme id. " + id));
		
	}
	
	public List<BombasDeCombustivel> buscarBombasDeCombustivel() {
		return bombaDeCombustivelRepository.findAll();
	}
	
	@Transactional
	public void deletarBombaDeCombustivel(Integer id) {
		bombaDeCombustivelRepository.deleteById(id);
	}
	
	@Transactional
	public void alterarBombaDeCombustivel(Integer id,BombasDeCombustivel bombasDeCombustivel) {
		BombasDeCombustivel bomba = buscarBombasDeCombustivelporId(id);
		bombasDeCombustivel.setId(bomba.getId());
		bombaDeCombustivelRepository.save(bombasDeCombustivel);
	}

}
