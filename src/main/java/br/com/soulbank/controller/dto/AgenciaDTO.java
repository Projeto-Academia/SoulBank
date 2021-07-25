package br.com.soulbank.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AgenciaDTO {

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


}

