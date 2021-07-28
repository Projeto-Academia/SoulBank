package br.com.soulbank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import br.com.soulbank.controller.dto.ClienteDTO;
import br.com.soulbank.service.ClienteServico;


@Controller
public class CadastroClienteController implements WebMvcConfigurer {

	@Autowired
	ClienteServico clienteServ;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/cadastrado").setViewName("cadastrado");
	}

	@GetMapping("/cadastrocliente")
	public String showForm(ClienteDTO clienteDTO) {
		return "cadastrocliente";
	}

	@PostMapping("/cadastrocliente")
	public String checkPersonInfo(@Valid ClienteDTO clienteDTO, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			return "cadastrocliente";
		}
		
		if (ClienteServico.validaCPF(clienteDTO.getCpf())){
			
			clienteServ.save(clienteDTO);
			
			return "redirect:/cadastrado";
		}
		
			return "redirect:/errocpf";
	}
}
