package com.fglanna_posto_combustivel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fglanna_posto_combustivel.entities.TiposDeCombustivel;
import com.fglanna_posto_combustivel.repositories.TipoDeCombustivelRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
public class TiposDeCombustivelService {
	
	private final TipoDeCombustivelRepository tipoDeCombustivelRepository;
	
	public TiposDeCombustivelService(TipoDeCombustivelRepository tipoDeCombustivelRepository) {
        this.tipoDeCombustivelRepository = tipoDeCombustivelRepository;
    }	
	
	public void criar(TiposDeCombustivel tiposDeCombustivel) {
		tipoDeCombustivelRepository.save(tiposDeCombustivel);
		
	}
	
	public TiposDeCombustivel buscarTiposDeCombustivelporId(Integer id) {
		return tipoDeCombustivelRepository.findById(id).orElseThrow(() -> new NullPointerException("Tipo de Combustível Inexistente conforme id. " + id));
		
	}
		
	public List<TiposDeCombustivel> buscarTiposDeCombustivel() {
		return tipoDeCombustivelRepository.findAll();
	}
	
	@Transactional
	public void deletarTipoDeCombustivel(Integer id) {
		tipoDeCombustivelRepository.deleteById(id);
		
	}
	
	public void alterarTipoDeCombustivel(Integer id,TiposDeCombustivel tiposDeCombustivel) {
		TiposDeCombustivel bomba = buscarTiposDeCombustivelporId(id);
		tiposDeCombustivel.setId(bomba.getId());
		tipoDeCombustivelRepository.save(tiposDeCombustivel);
	}

}
