package br.com.soulbank.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@SequenceGenerator(name = "idContaGen", sequenceName = "idContaGen", initialValue = 20000)
@Table(name = "conta")
public class ContaCorrente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idContaCorrente;
	
	@Column(nullable = false)
	@NotNull
	private double saldo;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
	private Cliente cliente;
	
	@OneToOne(mappedBy = "conta")
    private Extrato extrato;
	
	@JoinColumn(name = "idAgencia")
	@ManyToOne(targetEntity = Agencia.class)
	private Agencia agencia;
	
	public ContaCorrente() {
	}

	public ContaCorrente (long idContaCorrente, Cliente cliente, double saldo) {
		this.idContaCorrente = idContaCorrente;
		this.saldo = saldo;
	}

}
