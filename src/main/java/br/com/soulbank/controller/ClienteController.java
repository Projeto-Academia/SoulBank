package br.com.soulbank.controller;


import br.com.soulbank.entity.Cliente;
import br.com.soulbank.service.ClienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteServico servico;


	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
		cliente =  servico.save(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);

	}
	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
		cliente = servico.save(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(servico.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
		return ResponseEntity.ok(servico.getById(id));
	}
	
}
