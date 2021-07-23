package br.com.soulbank.service;

import br.com.soulbank.entity.Cliente;
import br.com.soulbank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;


//Colocando anotação @Service para indicar que a classe é Service.

@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepository clientrepository;

	//Definindo o método findAll que lista todos os clientes na lista Cliente.
	//RETURN -> uma lista com todos os clientes registrados
	public List<Cliente> findAll() {
		return clientrepository.findAll();
	}

	//Definindo o método getById que pega um cliente específico pelo id
	//RETURN -> o cliente específico ou mensagem de erro, caso o id não esteja registrado
	public Cliente getById(Long id) {
		return clientrepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	//Definindo o método save que salva um cliente.
	public Cliente save(Cliente cliente) {
		return clientrepository.save(cliente);
	}

	//Definindo o método delete que deleta um cliente específico.
	public void delete(Long id) {
		clientrepository.deleteById(id);
	}
	
}
