package br.com.soulbank.controller.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import br.com.soulbank.entity.ContaCorrente;
import br.com.soulbank.entity.Operacoes;
import lombok.Data;

@Data
public class ExtratoDTO {

	@NotNull
	private long idExtrato;
	private LocalDateTime dataEHora;
	
	@NotNull
	private Operacoes operacoes;
	
	private ContaCorrente conta;
	
	
}
