package br.com.soulbank.controller.dto;



import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
<<<<<<< HEAD:src/main/java/br/com/soulbank/controller/dto/ContaDTO.java
public class ContaDTO {
	
	@NotNull
	@Size(max = 5)
	private Long idAgencia;
	
	@NotNull
	@Size(max = 5)
	private Long idCliente;
=======
public class ContaCorrenteDTO {


	private long idContaCorrente;
>>>>>>> 1cf7a5c20c5daabf476ff45f6f11eb9e1fd36e42:src/main/java/br/com/soulbank/controller/dto/ContaCorrenteDTO.java
	
	@NotNull
	private double saldo;
	
	
}
