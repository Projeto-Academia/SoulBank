package br.com.soulbank.controller;

import br.com.soulbank.controller.dto.ClienteDTO;
import br.com.soulbank.entity.Cliente;
import br.com.soulbank.service.ClienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * ANOTAÇÃO QUE INDICA QUE É UMA CLASSE DE CONTROLE.
 * 
 * OS MÉTODOS QUE FORAM CRIADOS NA CLASSE 'ClienteService' VÃO SER CHAMADOS AQUI.
 * 
 * ESSA CLASSE CONTROLLER ELA É A RESPONSAVEL POR FAZER O SWAGGER FUNCIONAR.
 */
@RestController
//ANOTAÇÃO QUE IMPLEMENTA A URL.
@RequestMapping("/cliente")
public class ClienteController {

	// INJEÇÃO DE DEPEDÊNCIAS(DE UMA CLASSE EM OUTRA)
	// TÁ IMPLEMENTANDO A CLASSE SERVIÇO NA CONTROLLER.
	@Autowired
	private ClienteServico servico;

	/*
	 * POSTMAPPING - PERMITE A CRIAÇÃO DOS DADOS.
	 * 
	 * RespondeEntity - SIGNIFICA REPRESENTAR TODA A RESPOSTA HTTP.
	 * 
	 * REQUESTBODY - MAPEIA A SOLICITAÇÃO PARA O OBJETO cliente DA CLASSE Cliente.
	 * 
	 * servico - É O NOME DADO A CLASSE ClienteServico.
	 * 
	 * cliente = servico.save(cliente); - POR MEIO DO MÉTODO servico.save(cliente) O
	 * OBJETO cliente CRIADO PELA REQUISIÇÃO FEITA PELO @REQUESTBODY ESTÁ SENDO
	 * ADICIONADO NO OBJETO CLIENTE.
	 * 
	 * ESSE RETURN MOSTRA O STATUS DA OPERAÇÃO(200,404...) E O BODY DELA(CLIENTE QUE
	 * FOI ADICIONADO)
	 */
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente = servico.save(clienteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	/*
	 * DELETA ALGO PELO ID POR MAPEAMENTO(Mapping).
	 * 
	 * ID VAI EM CHAVE("/{id}") PORQUE É PARAMÊTRO DO HTTP.
	 * 
	 * PathVariable - É UTILIZADO QUANDO PASSAMOS VALOR DE UMA VARIÁVEL NO HTTP,
	 * NESTE CASO É O {id}.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		servico.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	/*
	 * GetMapping - MOSTRA TODOS OS DADOS.
	 * 
	 * O MÉTODO ResponseEntity TEM O TIPO LISTA, QUE, POR SUA VEZ, É DO TIPO
	 * CLIENTE. ASSIM ELE VAI PEGAR TODOS OS CLIENTES DA LISTA(getAll).
	 * 
	 * RETURN - ESTÁ RETORNANDO A CONFIRMAÇÃO MAIS TODOS OS CLIENTES(PELO MÉTODO
	 * serviço.findAll().
	 */
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(servico.findAll());
	}

	/*
	 * MOSTRA O DADO REFERENTE AO ID.
	 * 
	 * MESMA COISA QUE O ANTERIOR SÓ QUE AGORA APENAS O REQUISITADO.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
		return ResponseEntity.ok(servico.getById(id));
	}

}
