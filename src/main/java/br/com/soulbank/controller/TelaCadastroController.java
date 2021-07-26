package br.com.soulbank.controller;

import br.com.soulbank.controller.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.soulbank.repository.TelaCadastroRepository;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TelaCadastroController {
	
	@Autowired
	private TelaCadastroRepository telaCadastroRepository;

	//@RequestMapping(method = RequestMethod.GET, value = "/telacadastro");
	public String inicio() {
		return "/cadastro/telacadastro";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/salvarcadastro")
	public String salvar(ClienteDTO clienteDTO) {
		//telaCadastroCliente.save(clienteDTO);
		return "cadastro/telacadastro";
	}

	/*@RequestMapping("/telaCadastro")
	public String listar(Model model) {

		model.addAttribute("telaCadastroCliente", telaCadastro.findAll());
		
		return "cadastro/telaCadastroCliente";
	}*/

	
//	@PostMapping
//	public ResponseEntity<String> create(@RequestBody ClienteDTO clienteDTO){
//		servico.save(clienteDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso");
//	}

}
