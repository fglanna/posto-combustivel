package com.fglanna_posto_combustivel.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tipos_combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TiposDeCombustivel {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	@Column(name ="nome")
	private String nome;
	@Column(name = "preco_litro")
	private BigDecimal precoPorLitro;
	
	

	
	
}
