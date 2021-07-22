package br.com.soulbank.service;

import br.com.soulbank.entity.Cliente;
import br.com.soulbank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepository clientrepository;

	public List<Cliente> findAll() {
		return clientrepository.findAll();
	}

	public Cliente getById(Long id) {
		return clientrepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	public Cliente save(Cliente cliente) {
		return clientrepository.save(cliente);
	}

	public void delete(Long id) {
		clientrepository.deleteById(id);
	}
	
	
	
	
	

}
