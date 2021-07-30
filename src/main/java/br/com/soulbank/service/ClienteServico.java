package br.com.soulbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.soulbank.controller.dto.ClienteDTO;
import br.com.soulbank.entity.Cliente;
import br.com.soulbank.repository.ClienteRepository;
import br.com.soulbank.service.exceptions.DataBaseException;
import br.com.soulbank.service.exceptions.InvalidCPFException;
import br.com.soulbank.service.exceptions.ResourceNotFoundException;
import br.com.soulbank.service.exceptions.ValorNuloException;


@Service
public class ClienteServico {

	@Autowired
	private ClienteRepository clientrepository;

	public List<Cliente> findAll() {
		return clientrepository.findAll();
	}


	public Cliente getById(Long id) {
		return clientrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}


	public void save(ClienteDTO clienteDto) {

		try {
			if (validaCPF(clienteDto.getCpf())) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(clienteDto.getIdCliente());
				cliente.setCpf(clienteDto.getCpf());
				cliente.setFone(clienteDto.getFone());
				cliente.setNome(clienteDto.getNome());
				cliente.setSobrenome(clienteDto.getSobrenome());

				clientrepository.save(cliente);
			}
		}
		catch(DataIntegrityViolationException e) {
			throw new ValorNuloException(clienteDto);		
		}
	}

	public void deleteById(Long id) {

		clientrepository.deleteById(id);
	}

	//Método para validar o CPF
	public static boolean validaCPF(String cpf) {

		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			return true;
		}
		catch(InvalidStateException e) {
			throw new InvalidCPFException(cpf);
		}

		
	}

	public void deleteById(long id) {

		try {
			clientrepository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException (e.getMessage());
		}

	}
	
}
