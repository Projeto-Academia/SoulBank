package br.com.soulbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "extrato")
public class Extrato {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idExtrato;
	
	private String dataHora;
	
	@Column(nullable = false)
	@NotNull
	private Operacoes operacoes;
	
	@Column(nullable = false)
	@NotNull
	private double valorOperacao;

	//aqui estamos mapeando um para um e introduzindo a chave estrangeira na tabela
	
	@JsonIgnore
	@JoinColumn(name = "idContaCorrente")
	@ManyToOne(targetEntity = ContaCorrente.class)
	private ContaCorrente conta;
	
	
	public Extrato() {
	}

	public Extrato(ContaCorrente conta, long idExtrato, String dataHora, Operacoes operacoes, double valorOperacao) {
		this.conta = conta;
		this.idExtrato = idExtrato;
		this.dataHora = dataHora;
		this.operacoes = operacoes;
		this.valorOperacao = valorOperacao;
	}

}
