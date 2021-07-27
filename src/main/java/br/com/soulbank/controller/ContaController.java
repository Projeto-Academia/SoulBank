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

	@GetMapping
	public ResponseEntity<List<ContaCorrente>> getAll() {
		return ResponseEntity.ok(servico.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaCorrente> getById(@PathVariable Long id) {
		return ResponseEntity.ok(servico.getById(id));
	}

	@PutMapping("/deposito")
	public ResponseEntity<String> depositando(@RequestBody long idConta, double valor) {
		return ResponseEntity.ok(servico.Depositar(idConta, valor));
	}

	@PutMapping("/transferencia")
	public ResponseEntity<String> transferindo(long idContaOrigem, long idContaDestino,
			double valor) {
		return ResponseEntity.ok(servico.Transferir(idContaOrigem, idContaDestino, valor));
	}

	@PutMapping("/saque")
	public ResponseEntity<String> sacando(@RequestBody long idConta, double valor) {
		return ResponseEntity.ok(servico.Sacar(idConta, valor));
	}

	@GetMapping("/visualizandoSaldo")
	public ResponseEntity<String> visualizandoSaldo(long idConta) {
		return ResponseEntity.ok(servico.RetornarSaldo(idConta));
	}

//ultimachave
}
