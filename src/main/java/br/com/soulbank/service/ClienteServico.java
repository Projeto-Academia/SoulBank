package br.com.soulbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.soulbank.controller.dto.ClienteDTO;
import br.com.soulbank.entity.Cliente;
import br.com.soulbank.repository.ClienteRepository;
import br.com.soulbank.service.exceptions.ResourceNotFoundException;

=======
import br.com.soulbank.controller.dto.ClienteDTO;
import br.com.soulbank.entity.Cliente;
import br.com.soulbank.repository.ClienteRepository;
import br.com.soulbank.service.exceptions.DataBaseException;
import br.com.soulbank.service.exceptions.ResourceNotFoundException;
>>>>>>> 2722ce61a050fb24e327fe0b8e0bdc07f701c111

//Colocando anotação @Service para indicar que a classe é Service.

/*
 * INDICA QUE É UMA CLASSE DE SERVIÇO.
 * 
 * ISSO QUER DIZER QUE TODOS OS MÉTODOS DA CLASSE CLIENTE FICAM AQUI PARA SEREM CHAMADOS PELA CLASSE 'ClienteController'
 */

@Service
public class ClienteServico {

	// INJEÇÃO DE DEPEDÊNCIA(DE UMA CLASSE-REPOSITORY- EM OUTRA-SERVICE- PORQUE A
	// ÚLTIMA DEPENDE DA PRIMEIRA)

	@Autowired
	private ClienteRepository clientrepository;

	// Definindo o método findAll que lista todos os clientes na lista Cliente.
	// RETURN -> uma lista com todos os clientes registrados
	// ESTE MÉTODO ESTÁ RETORNANDO PELO findALl UMA LISTA COMPLETA DA CLASSE
	// CLIENTE.

	public List<Cliente> findAll() {
		return clientrepository.findAll();
	}

	// Definindo o método getById que pega um cliente específico pelo id
	// RETURN -> o cliente específico ou mensagem de erro, caso o id não esteja
	// registrado

	// ESTE MÉTODO ESTÁ RETORNANDO UM CLIENTE PELO ID(getById).
	//
	// EXPRESSÃO LAMBDA: PELO findById TENTA-SE ENCONTRAR O CLIENTE PELO ID, 'CASO
	// NÃO, LANÇA'(orElseThrow) INSTANCIA UMA NOVA ENTIDADE NO
	// 'EntityNotFoundException'.

	public Cliente getById(Long id) {
		return clientrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	// Definindo o método save que salva um cliente.
	// PELO MÉTODO, UM OBJETO CLIENTE É SALVO NA CLASSE CLIENTE.

	public Cliente save(ClienteDTO clienteDto) {

		Cliente cliente = new Cliente();

		cliente.setIdCliente(clienteDto.getIdCliente());
		cliente.setCpf(clienteDto.getCpf());
		cliente.setFone(clienteDto.getFone());
		cliente.setNome(clienteDto.getNome());
		cliente.setSobrenome(clienteDto.getSobrenome());
		return clientrepository.save(cliente);
	}

	// Definindo o método delete que deleta um cliente específico.
	public void deleteById(Long id) {
<<<<<<< HEAD
		clientrepository.deleteById(id);
	}

	//Método para validar o CPF
	public boolean validaCPF(String cpf) {

		CPFValidator cpfValidator = new CPFValidator();

		cpfValidator.assertValid(cpf);
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf); 

		if (erros.size() > 0) {
			return false;
		}
		return true;
	}

	
=======
		try {
			clientrepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException (e.getMessage());
		}

	}
//ultimachave
>>>>>>> 2722ce61a050fb24e327fe0b8e0bdc07f701c111
}
