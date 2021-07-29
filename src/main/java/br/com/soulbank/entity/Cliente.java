package br.com.soulbank.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(nullable = false)
	@NotNull
	@Size(max = 45)
	private String nome;
	
	@Column(nullable = false)
	@NotNull
	@Size(max = 45)
	private String sobrenome;
	
	@Column(nullable = false)
	@NotNull
	@Size(max = 14)
	private String cpf;
	
	@Column(nullable = false)
	@NotNull
	@Size(max = 13)
	private String fone;

	
	public Cliente() {
	}

	public Cliente(long idCliente, String nome, String sobrenome, String cpf, String fone) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.fone = fone;
	}

}
