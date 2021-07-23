package br.com.soulbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soulbank.entity.ContaCorrente;
import br.com.soulbank.service.ContaServico;

@RestController
@RequestMapping
public class ContaController {

	@Autowired
	private ContaServico servico;


	@PostMapping
	public ResponseEntity<ContaCorrente> create(@RequestBody ContaCorrente conta){
		conta =  servico.save(conta);
		return ResponseEntity.status(HttpStatus.CREATED).body(conta);

	}
	@PutMapping
	public ResponseEntity<ContaCorrente> update(@RequestBody ContaCorrente conta){
		conta = servico.save(conta);
		return ResponseEntity.ok(conta);
	}


	@GetMapping
	public ResponseEntity<List<ContaCorrente>> getAll() {
		return ResponseEntity.ok(servico.findAll());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<ContaCorrente> getById(@PathVariable Long id) {
		return ResponseEntity.ok(servico.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<String> depositando (@PathVariable Long idContaCorrente, double valor) {
		return ResponseEntity.ok(servico.Depositar(valor));
	}
	
	@PostMapping
	public ResponseEntity<String> transferindo (@PathVariable ContaCorrente contaOrigem, ContaCorrente contaDestino, double valor) {
		return  ResponseEntity.ok(servico.Transferir(contaOrigem, contaDestino, valor));
	}
	
	
	
	
	
}
