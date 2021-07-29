package br.com.soulbank.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ContaCorrenteDTO {

	@JsonIgnore
	private long idContaCorrente;
	
	@NotNull
	private double saldo;
	
	@NotNull
	@Size(max = 5)
	private Long idAgencia;
	
	@NotNull
	@Size(max = 5)
	private Long idCliente;

	public ContaCorrenteDTO(long idContaCorrente, double saldo, Long idAgencia, Long idCliente) {
		this.idContaCorrente = idContaCorrente;
		this.saldo = saldo;
		this.idAgencia = idAgencia;
		this.idCliente = idCliente;
	}
	
	
}
