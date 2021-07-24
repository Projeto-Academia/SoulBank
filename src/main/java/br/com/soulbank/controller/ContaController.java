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

import br.com.soulbank.controller.dto.ContaCorrenteDTO;
import br.com.soulbank.entity.ContaCorrente;
import br.com.soulbank.service.ContaServico;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaServico servico;

	@PostMapping
	public ResponseEntity<ContaCorrente> create(@RequestBody ContaCorrenteDTO contaCorrenteDTO) {
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente = servico.save(contaCorrenteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(contaCorrente);
	}

	@PutMapping
	public ResponseEntity<ContaCorrente> update(@RequestBody ContaCorrenteDTO contaCorrenteDTO) {
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente = servico.save(contaCorrenteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(contaCorrente);
	}

	@GetMapping
	public ResponseEntity<List<ContaCorrente>> getAll() {
		return ResponseEntity.ok(servico.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaCorrente> getById(@PathVariable Long id) {
		return ResponseEntity.ok(servico.getById(id));
	}

	@PutMapping("/deposito")
	public ResponseEntity<String> depositando(@RequestBody Long idContaCorrente, double valor) {
		return ResponseEntity.ok(servico.Depositar(valor));
	}

	@PutMapping("/transferencia")
	public ResponseEntity<String> transferindo(@RequestBody ContaCorrente contaOrigem, ContaCorrente contaDestino,
			double valor) {
		return ResponseEntity.ok(servico.Transferir(contaOrigem, contaDestino, valor));
	}

	@PutMapping("/saque")
	public ResponseEntity<String> sacando(@RequestBody ContaCorrente contaOrigem, double valor) {
		return ResponseEntity.ok(servico.Sacar(valor));
	}

	@GetMapping("/visualizandoSaldo")
	public ResponseEntity<String> visualizandoSaldo(double saldoAtual) {
		return ResponseEntity.ok(servico.RetornarSaldo(saldoAtual));
	}

//ultimachave
}
