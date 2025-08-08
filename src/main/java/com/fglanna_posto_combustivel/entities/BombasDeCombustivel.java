package com.fglanna_posto_combustivel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "bombas_combustivel")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BombasDeCombustivel {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "combustivel_id")
	private TiposDeCombustivel tiposDeCombustivel;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TiposDeCombustivel getTiposDeCombustivel() {
		return tiposDeCombustivel;
	}

	public void setTiposDeCmbustivel(TiposDeCombustivel tiposDeCombustivel) {
		this.tiposDeCombustivel = tiposDeCombustivel;
	}
	
	

}
