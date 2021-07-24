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

import br.com.soulbank.controller.dto.AgenciaDTO;
import br.com.soulbank.entity.Agencia;
import br.com.soulbank.service.AgenciaServico;

@RestController
@RequestMapping("/agencia")
public class AgenciaController {
	
	@Autowired
	private AgenciaServico servico;


	@PostMapping
	public ResponseEntity<Agencia> create(@RequestBody AgenciaDTO agenciaDTO){
		Agencia agencia =  new Agencia();
		agencia = servico.save(agenciaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(agencia);

	}
	@PutMapping
	public ResponseEntity<Agencia> update(@RequestBody AgenciaDTO agenciaDTO){
		Agencia agencia =  new Agencia();
		agencia = servico.save(agenciaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(agencia);
	}


	@GetMapping
	public ResponseEntity<List<Agencia>> getAll() {
		return ResponseEntity.ok(servico.findAll());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Agencia> getById(@PathVariable Long id) {
		return ResponseEntity.ok(servico.getById(id));
	}
	
}
