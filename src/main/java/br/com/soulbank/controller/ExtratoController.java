package br.com.soulbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import br.com.soulbank.entity.Extrato;
import br.com.soulbank.repository.ExtratoRepository;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {
	
	@Autowired
	private ExtratoRepository extrato;
		
		@GetMapping
		public ModelAndView listar() {
			List<Extrato> listaextrato= extrato.findAll();
			
			ModelAndView modelAndView = new ModelAndView("extrato");		
			modelAndView.addObject("extrato", listaextrato);
			
			return modelAndView;
		}
	}

