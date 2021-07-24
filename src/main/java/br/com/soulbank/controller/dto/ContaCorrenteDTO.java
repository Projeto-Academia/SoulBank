package br.com.soulbank.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class ContaCorrenteDTO {


	private long idContaCorrente;
	
	@NotNull
	private double saldo;
	
	@NotNull
	@Size(max = 5)
	private Long idAgencia;
	
	@NotNull
	@Size(max = 5)
	private Long idCliente;
}
