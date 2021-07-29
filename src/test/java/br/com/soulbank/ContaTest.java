package br.com.soulbank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.soulbank.controller.dto.AgenciaDTO;
import br.com.soulbank.controller.dto.ClienteDTO;
import br.com.soulbank.controller.dto.ContaCorrenteDTO;
import br.com.soulbank.entity.Agencia;
import br.com.soulbank.entity.Cliente;
import br.com.soulbank.entity.ContaCorrente;
import br.com.soulbank.service.AgenciaServico;
import br.com.soulbank.service.ClienteServico;
import br.com.soulbank.service.ContaServico;

@SpringBootTest
public class ContaTest {

	@Autowired
	private ContaServico contaServ;
	@Autowired
	private AgenciaServico agenciaServ;
	@Autowired
	private ClienteServico clienteServ;

	@Test
	public void testeGetAllConta() {
		
		ClienteDTO clienteDTO = new ClienteDTO(1L, "João", "Silva", "115.556.904-08", "3333-4444");
		clienteServ.save(clienteDTO);
		AgenciaDTO agenciaDTO = new AgenciaDTO(1L, "Soulbank", "Avenida Paulista, 205 - SP", "3333-4444");
		agenciaServ.save(agenciaDTO);
		
		ContaCorrenteDTO contaDTO = new ContaCorrenteDTO(1L, 500.0, agenciaDTO.getIdAgencia(), clienteDTO.getIdCliente());
		ContaCorrenteDTO contaDTO2 = new ContaCorrenteDTO(2L, 700.0, agenciaDTO.getIdAgencia(), clienteDTO.getIdCliente());
		
		contaServ.save(contaDTO);
		contaServ.save(contaDTO2);
		
		assertEquals(2, contaServ.findAll().size());
	}
	
	@Test
	public void testeSaveConta(){

		ClienteDTO clienteDTO = new ClienteDTO(1L, "João", "Silva", "115.556.904-08", "3333-4444");
		clienteServ.save(clienteDTO);
		AgenciaDTO agenciaDTO = new AgenciaDTO(1L, "Soulbank", "Avenida Paulista, 205 - SP", "3333-4444");
		Agencia agencia = agenciaServ.save(agenciaDTO);
		
		Cliente cliente = new Cliente (clienteDTO.getIdCliente(), clienteDTO.getNome(), clienteDTO.getSobrenome(), clienteDTO.getCpf(), clienteDTO.getFone());
		
		ContaCorrenteDTO contaDTO = new ContaCorrenteDTO(1L, 500.0, agenciaDTO.getIdAgencia(), clienteDTO.getIdCliente());

		ContaCorrente conta = contaServ.save(contaDTO);

		assertThat(conta.getIdContaCorrente()).isNotNull();
		assertEquals(500.0, conta.getSaldo());
		assertEquals(agencia, conta.getAgencia());
		assertEquals(cliente, conta.getCliente());
	}
	
	@Test
	public void testeGetByIdConta() {
		ClienteDTO clienteDTO = new ClienteDTO(1L, "João", "Silva", "115.556.904-08", "3333-4444");
		clienteServ.save(clienteDTO);
		AgenciaDTO agenciaDTO = new AgenciaDTO(1L, "Soulbank", "Avenida Paulista, 205 - SP", "3333-4444");
		agenciaServ.save(agenciaDTO);
		
		ContaCorrenteDTO contaDTO = new ContaCorrenteDTO(1L, 500.0, agenciaDTO.getIdAgencia(), clienteDTO.getIdCliente());

		ContaCorrente conta = contaServ.save(contaDTO);
		
		assertEquals(conta, contaServ.getById(conta.getIdContaCorrente()));
	}

}