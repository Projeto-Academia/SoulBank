package br.com.soulbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.soulbank.repository.ExtratoRepository;

@Controller
public class ExtratoController {

//	@Autowired
//	private ExtratoServico extrato;
	@Autowired
	private ExtratoRepository extrato;

	@RequestMapping("/extrato/{idContaCorrente}")
	public String listar(Model model, @PathVariable long idContaCorrente) {

		model.addAttribute("extrato", extrato.findAllByIdConta(idContaCorrente));
		
		return "extrato";
	}
}