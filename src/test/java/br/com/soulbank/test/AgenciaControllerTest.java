package br.com.soulbank.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.soulbank.controller.AgenciaController;
import br.com.soulbank.controller.dto.AgenciaDTO;
import br.com.soulbank.entity.Agencia;

@SpringBootTest
class AgenciaControllerTest extends AgenciaController {

	@Autowired
	AgenciaController agenciaTeste;
	
		
	@Test
	public void testeCriarAgencia() {
		AgenciaDTO agenciadto = new AgenciaDTO(2000,"SoulBank","Avenida Paulista","8345-2231");
		long id = 2000;
		assertEquals(id, agenciadto.getIdAgencia());
		String ag = "SoulBank";
		assertEquals(ag, agenciadto.getNomeDaAgencia());
		String ed = "Avenida Paulista";
		assertEquals(ed,agenciadto.getEndereco());
		String tel = "8345-2231";
		assertEquals(tel, agenciadto.getTelefone());
		
		agenciaTeste.create(agenciadto);
//		agenciaTeste.getAll();
//		agenciaTeste.getById(agenciadto.getIdAgencia());
	}
	
//	public void testeiachardAgencia() {
//		AgenciaDTO agenciadto = new AgenciaDTO(4,"SoulBank","Avenida Paulista","8345-2231");
//		long id = agenciadto.getIdAgencia();
//		assertEquals(id, agenciadto.getIdAgencia());
//		
//		agenciaTeste.getAll();
//	}
	
	
	
	
//	@Test
//	public void salvar() {
//		
//	}
}
