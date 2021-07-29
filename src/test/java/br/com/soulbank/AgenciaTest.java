package br.com.soulbank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.soulbank.controller.dto.AgenciaDTO;
import br.com.soulbank.entity.Agencia;
import br.com.soulbank.service.AgenciaServico;

@SpringBootTest
public class AgenciaTest {

	@Autowired
	private AgenciaServico agenciaServ;

	@Test
	public void testeGetAllAg() {
		AgenciaDTO agenciaDTO = new AgenciaDTO(1L, "Soulbank", "Avenida Paulista, 205 - SP", "3333-4444");
		AgenciaDTO agenciaDTO2 = new AgenciaDTO(2L, "Soulbank", "Avenida Paulista, 205 - SP", "3333-4444");
		
		agenciaServ.save(agenciaDTO);
		agenciaServ.save(agenciaDTO2);
		
		assertEquals(2, agenciaServ.findAll().size());
	}
	
	@Test
	public void testeSaveAgencia(){

		AgenciaDTO agenciaDTO = new AgenciaDTO(1L, "Soulbank", "Avenida Paulista, 205 - SP", "3333-4444");

		Agencia agencia = agenciaServ.save(agenciaDTO);

		assertThat(agencia.getIdAgencia()).isNotNull();
		assertEquals("Soulbank", agencia.getNomeDaAgencia());
		assertEquals("Avenida Paulista, 205 - SP", agencia.getEndereco());
		assertEquals("3333-4444", agencia.getTelefone());
	}
	
	@Test
	public void testeGetByIdAg() {
		AgenciaDTO agenciaDTO = new AgenciaDTO(1L, "Soulbank", "Avenida Paulista, 205 - SP", "3333-4444");

		Agencia agencia = agenciaServ.save(agenciaDTO);
		
		assertEquals(agencia, agenciaServ.getById(agencia.getIdAgencia()));
	}

}
