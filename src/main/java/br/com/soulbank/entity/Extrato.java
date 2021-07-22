package br.com.soulbank.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "extrato")
public class Extrato {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idExtrato;
	private LocalDateTime dataHora;
	@Column(nullable = false)
	@NotNull
	private Operacoes operacoes;
	@Column(nullable = false)
	@NotNull
	private double valor;

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idContaCorrente", referencedColumnName = "idContaCorrente")
	private ContaCorrente conta;
	
	
	public Extrato(double valor) {
	}

	public Extrato(long idExtrato, LocalDateTime dataHora, Operacoes operacoes) {
		this.idExtrato = idExtrato;
		this.dataHora = dataHora;
//		this.contaCorrente = contaCorrente;
		this.operacoes = operacoes;
	}

}

//TESTE