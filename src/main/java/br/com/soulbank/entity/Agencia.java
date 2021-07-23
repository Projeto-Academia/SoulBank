package br.com.soulbank.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "agencia")
public class Agencia {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idAgencia;
	
	@Column(nullable = false)
	@NotNull
	@Size(max=45)
	private String nomeDaAgencia;
	
	@Column(nullable = false)
	@NotNull
	@Size(max=45)
	private String endereco;
	
	@Column(nullable = false)
	@NotNull
	@Size(max=15)
	private String telefone;
	
	public Agencia() {
	}

	public Agencia(long idAgencia, String nomeDaAgencia, String endereco, String telefone) {
		this.idAgencia = idAgencia;
		this.nomeDaAgencia = nomeDaAgencia;
		this.endereco = endereco;
		this.telefone = telefone;
	}

}
