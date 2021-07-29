package br.com.soulbank.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class AgenciaDTO {
	
	@JsonIgnore
    private Long idAgencia;

    @NotNull
    @Size(max = 45)
    private String nomeDaAgencia;

    @NotNull
    @Size(max = 45)
    private String endereco;

    @NotNull
    @Size(max = 14)
    private String telefone;

    public AgenciaDTO(long idAgencia, String nomeDaAgencia, String endereco, String telefone) {
    	this.idAgencia = idAgencia;
    	this.nomeDaAgencia = nomeDaAgencia;
    	this.endereco = endereco;
    	this.telefone = telefone;
    }
}

