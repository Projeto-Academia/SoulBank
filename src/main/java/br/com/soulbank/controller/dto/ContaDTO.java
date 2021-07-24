package br.com.soulbank.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class ContaDTO {
	
	@NotNull
	private Long idAgencia;
	
	@NotNull
	@Size(max = 5)
	private Long idCliente;
	
	@NotNull
	private double saldo;
	
}
