package br.com.soulbank.controller;


import br.com.soulbank.controller.dto.ClienteDTO;
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
	public ResponseEntity<String> create(@RequestBody ClienteDTO clienteDTO){
		servico.save(clienteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso");
	}
	
//	@PutMapping
//	public ResponseEntity<Cliente> update(@RequestBody ClienteDTO clienteDTO){
//		Cliente cliente = new Cliente();
//		cliente = servico.save(clienteDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		servico.deleteById(id);
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
