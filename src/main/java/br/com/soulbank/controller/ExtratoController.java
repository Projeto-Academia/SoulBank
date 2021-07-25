package br.com.soulbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import br.com.soulbank.service.ExtratoServico;

@Controller

public class ExtratoController {

	@Autowired
	private ExtratoServico extrato;

	@RequestMapping("/extrato")
	public String listar(Model model) {

		model.addAttribute("extrato", extrato.findAll());
		
		return "extrato";
	}
}

