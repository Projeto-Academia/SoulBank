package br.com.soulbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.soulbank.repository.TelaCadastroRepository;

@Controller
public class TelaCadastroController {
	
	@Autowired
	private TelaCadastroRepository telaCadastro;

	@RequestMapping("/telaCadastro")
	public String listar(Model model) {

		model.addAttribute("telaCadastroCliente", telaCadastro.findAll());
		
		return "cadastro/telaCadastroCliente";
	}

	
//	@PostMapping
//	public ResponseEntity<String> create(@RequestBody ClienteDTO clienteDTO){
//		servico.save(clienteDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso");
//	}

}
