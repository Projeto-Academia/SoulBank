package br.com.soulbank.service;

import br.com.soulbank.entity.Cliente;
import br.com.soulbank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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

	// ESTE MÉTODO ESTÁ RETORNANDO PELO findALl UMA LISTA COMPLETA DA CLASSE
	// CLIENTE.
	public List<Cliente> findAll() {
		return clientrepository.findAll();
	}

	/*
	 * ESTE MÉTODO ESTÁ RETORNANDO UM CLIENTE PELO ID(getById).
	 * 
	 * EXPRESSÃO LAMBDA: PELO findById TENTA-SE ENCONTRAR O CLIENTE PELO ID, 'CASO
	 * NÃO, LANÇA'(orElseThrow) INSTANCIA UMA NOVA ENTIDADE NO
	 * 'EntityNotFoundException'.
	 */
	public Cliente getById(Long id) {
		return clientrepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	// PELO MÉTODO, UM OBJETO CLIENTE É SALVO NA CLASSE CLIENTE.
	public Cliente save(Cliente cliente) {
		return clientrepository.save(cliente);
	}

	// PELO MÉTODO, UM OBJETO CLIENTE É DELETADO PELO ID NA CLASSE CLIENTE.
	public void delete(Long id) {
		clientrepository.deleteById(id);
	}

}
