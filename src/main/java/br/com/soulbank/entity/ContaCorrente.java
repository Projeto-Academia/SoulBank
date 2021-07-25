package br.com.soulbank.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@SequenceGenerator(name = "idContaGen", sequenceName = "idContaGen", initialValue = 20000)
@Table(name = "conta")
public class ContaCorrente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idContaCorrente;
	
	@Column(nullable = false)
	@NotNull
	private double saldo;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
	private Cliente cliente;
	
	@JsonIgnore
	@OneToOne(mappedBy = "conta")
    private Extrato extrato;
	
	@JsonIgnore
	@JoinColumn(name = "idAgencia")
	@ManyToOne(targetEntity = Agencia.class)
	private Agencia agencia;
	
	public ContaCorrente() {
	}

	public ContaCorrente (long idContaCorrente, Cliente cliente, Agencia agencia, double saldo) {
		this.idContaCorrente = idContaCorrente;
		this.saldo = saldo;
		this.cliente = cliente;
		this.agencia = agencia;
	}

}
