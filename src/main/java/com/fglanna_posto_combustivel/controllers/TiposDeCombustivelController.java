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
import com.fglanna_posto_combustivel.entities.TiposDeCombustivel;
import com.fglanna_posto_combustivel.services.AbastecimentoService;
import com.fglanna_posto_combustivel.services.TiposDeCombustivelService;

import lombok.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tiposDeCombustivel")
public class TiposDeCombustivelController {
	
	private final TiposDeCombustivelService tiposDeCombustivelService;
	
	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody TiposDeCombustivel tiposDeCombustivel) {		
		tiposDeCombustivelService.criar(tiposDeCombustivel);
		return ResponseEntity.accepted().build();
	}

	@GetMapping
	public ResponseEntity<List<TiposDeCombustivel>> buscarTiposDeCombustivel() {
		return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TiposDeCombustivel> buscarTiposDeCombustivelPorId(@PathVariable(name = "id") Integer id) {
		return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivelporId(id));		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarTiposDeCmbustivelPorId(@PathVariable(name = "id") Integer id) {
		tiposDeCombustivelService.deletarTipoDeCombustivel(id);
		return ResponseEntity.ok().build();		
		
	}

	@PutMapping
	public ResponseEntity<Void> alterarTipoDeCombustivel(@RequestParam(name = "id") Integer id,
														@RequestBody TiposDeCombustivel tiposDeCombustivel) {		
		tiposDeCombustivelService.alterarTipoDeCombustivel(id, tiposDeCombustivel);
		return ResponseEntity.ok().build();
	}

}
