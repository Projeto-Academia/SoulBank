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
//	@Autowired
//	private ExtratoDTORepository extratoDTOrepository;


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

	
	//filtrar extrato pelo id da conta corrente
//	public List<Extrato> extratoPorConta(long idContaCorrente) {
//		
////		List<Extrato> extratos = extratorepository.findAll();
////		List<ExtratoDTO> extratosDTO = extratos.stream().map(x -> new ExtratoDTO(x)).collect(Collectors.toList());
//		
//		return extratorepository.findAllByIdConta(idContaCorrente);
//	}
}

