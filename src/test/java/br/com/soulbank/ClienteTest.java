package br.com.soulbank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.soulbank.controller.dto.ClienteDTO;
import br.com.soulbank.entity.Cliente;
import br.com.soulbank.service.ClienteServico;

@SpringBootTest
public class ClienteTest {

	@Autowired
	private ClienteServico clienteServ;

	@Test
	public void testeGetAllCliente() {
		ClienteDTO clienteDTO = new ClienteDTO(1L, "João", "Silva", "115.556.904-08", "3333-4444");
		ClienteDTO clienteDTO2 = new ClienteDTO(2L, "Raimundo", "Silva", "115.556.904-08", "3333-4444");
		
		clienteServ.save(clienteDTO);
		clienteServ.save(clienteDTO2);
		
		assertEquals(2, clienteServ.findAll().size());
	}
	
	@Test
	public void testeGetByIdCliente() {
		ClienteDTO clienteDTO = new ClienteDTO(1L, "João", "Silva", "115.556.904-08", "3333-4444");

		clienteServ.save(clienteDTO);
		
		Cliente cliente = new Cliente (clienteDTO.getIdCliente(), clienteDTO.getNome(), clienteDTO.getSobrenome(), clienteDTO.getCpf(), clienteDTO.getFone());
		
		assertEquals(cliente, clienteServ.getById(cliente.getIdCliente()));
	}

}
