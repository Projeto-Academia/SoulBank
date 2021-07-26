package br.com.soulbank.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class ClienteDTO {
	
	@JsonIgnore
    private Long idCliente;

    @NotNull
    @Size(max = 45)
    private String nome;

    @NotNull
    @Size(max = 45)
    private String sobrenome;

    @NotNull
    @Size(max = 14)
    private String cpf;

    @NotNull
    @Size(max = 13)
    private String fone;

}
