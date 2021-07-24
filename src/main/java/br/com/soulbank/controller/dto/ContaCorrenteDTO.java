package br.com.soulbank.controller.dto;



import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ContaCorrenteDTO {


	private long idContaCorrente;
	
	@NotNull
	private double saldo;
	
	
}
