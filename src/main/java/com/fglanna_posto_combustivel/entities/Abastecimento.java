package com.fglanna_posto_combustivel.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.*;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "abastecimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Abastecimento {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "bomba_combustivel_id")
	private BombasDeCombustivel bombaDeCombustivel;
	
	@Column(name = "data_abastecimento")
	private LocalDate dataAbastecimento;
	
	@Column(name = "valor_toal")
	private BigDecimal valorTotal;
	
	@Column(name = "quantidade_litros")
	private Long quantidadeLitros;
	

}
