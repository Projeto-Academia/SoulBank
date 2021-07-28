package br.com.soulbank.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ClienteDTO {
	
	@JsonIgnore
    private Long idCliente;

    @NotNull(message ="O campo 'nome' não pode estar vazio.")
    @NotEmpty(message ="O campo 'nome' não pode estar vazio.")
    @Size(max = 45)
    private String nome;

    @NotNull(message ="O campo 'sobrenome' não pode estar vazio.")
    @NotEmpty(message ="O campo 'sobrenome' não pode estar vazio.")
    @Size(max = 45)
    private String sobrenome;

    @CPF(message="CPF inválido")
    @NotNull(message ="O campo 'CPF' não pode estar vazio.")
    @NotEmpty(message ="O campo 'CPF' não pode estar vazio.")
    @Size(min = 14 , max = 14, message ="CPF deve estar no formato XXX.XXX.XXX-XX")
    private String cpf;

    @NotNull(message ="O campo 'telefone' não pode estar vazio.")
    @NotEmpty(message ="O campo 'telefone' não pode estar vazio.")
    @Size(max = 13)
    private String fone;

}
