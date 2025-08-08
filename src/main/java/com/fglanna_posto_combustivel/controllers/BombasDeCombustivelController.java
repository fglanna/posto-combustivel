package com.fglanna_posto_combustivel.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fglanna_posto_combustivel.entities.Abastecimento;
import com.fglanna_posto_combustivel.entities.BombasDeCombustivel;
import com.fglanna_posto_combustivel.entities.TiposDeCombustivel;
import com.fglanna_posto_combustivel.services.AbastecimentoService;
import com.fglanna_posto_combustivel.services.BombaDeCombustivelService;
import com.fglanna_posto_combustivel.services.TiposDeCombustivelService;

import lombok.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bombasDeCombustivel")
public class BombasDeCombustivelController {
	
	private final BombaDeCombustivelService bombaDeCombustivelService;
	
	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody BombasDeCombustivel bombasDeCombustivel) {		
		bombaDeCombustivelService.criar(bombasDeCombustivel);
		return ResponseEntity.accepted().build();
	}

	@GetMapping
	public ResponseEntity<List<BombasDeCombustivel>> buscarBombasDeCombustivel() {
		return ResponseEntity.ok(bombaDeCombustivelService.buscarBombasDeCombustivel());	
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BombasDeCombustivel> buscarBombasDeCombustivelPorId(@PathVariable(name = "id") Integer id) {
		return ResponseEntity.ok(bombaDeCombustivelService.buscarBombasDeCombustivelporId(id));		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarBombasDeCmbustivelPorId(@PathVariable(name = "id") Integer id) {
		bombaDeCombustivelService.deletarBombaDeCombustivel(id);
		return ResponseEntity.ok().build();		
		
	}

	@PutMapping
	public ResponseEntity<Void> alterarBombaDeCombustivel(@RequestParam(name = "id") Integer id,
														@RequestBody BombasDeCombustivel bombasDeCombustivel) {		
		bombaDeCombustivelService.alterarBombaDeCombustivel(id, bombasDeCombustivel);
		return ResponseEntity.ok().build();
	}

}
