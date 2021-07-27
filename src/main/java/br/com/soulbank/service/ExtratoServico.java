package br.com.soulbank.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.soulbank.entity.Extrato;
import br.com.soulbank.repository.ExtratoRepository;
import br.com.soulbank.service.exceptions.ResourceNotFoundException;

@Service
public class ExtratoServico {
	
	@Autowired
	private ExtratoRepository extratorepository;


	public List<Extrato> findAll() {
		return extratorepository.findAll();
	}

	public Extrato getById(Long id) {
		return extratorepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Extrato save(Extrato extrato) {

		return extratorepository.save(extrato);
	}

}

