package com.fglanna_posto_combustivel.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fglanna_posto_combustivel.entities.Abastecimento;
import com.fglanna_posto_combustivel.entities.BombasDeCombustivel;
import com.fglanna_posto_combustivel.repositories.AbastecimentoRepository;

@Service

public class AbastecimentoService {
	
	private final AbastecimentoRepository abastecimentoRepository;
	
	private final BombaDeCombustivelService bombaDeCombustivelService;
	
	public AbastecimentoService(AbastecimentoRepository abastecimentoRepository, BombaDeCombustivelService bombaDeCombustivelService) {
        this.abastecimentoRepository = abastecimentoRepository;
        this.bombaDeCombustivelService = bombaDeCombustivelService;
	}
	
	public void abastecer(Integer idBomba, Long litros) {
		BombasDeCombustivel bomba = bombaDeCombustivelService.buscarBombasDeCombustivelporId(idBomba);
		BigDecimal valorTotal = bomba.getTiposDeCombustivel()
				.getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));
		
		Abastecimento abastecimento = Abastecimento.builder()
				.dataAbastecimento(LocalDate.now())
				.bombasDeCombustivel(bomba)
				.valorTotal(valorTotal)
				.quantidadeLitros(litros)				
				.build();
		
		abastecimentoRepository.save(abastecimento);
	}
	
	public List<Abastecimento> buscarAbastecimento() {
		return abastecimentoRepository.findAll();
	}
}
