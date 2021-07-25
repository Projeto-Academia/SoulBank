package br.com.soulbank.service;

import br.com.soulbank.controller.dto.AgenciaDTO;
import br.com.soulbank.entity.Agencia;
import br.com.soulbank.repository.AgenciaRepository;
import br.com.soulbank.service.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaServico {
	
	@Autowired
	private AgenciaRepository agenciarepository;

	//Definindo o método findAll que lista todas as agências.
	//RETURN -> uma lista com todas as agências registradas
	public List<Agencia> findAll() {
		return agenciarepository.findAll();
	}

	//Definindo o método getById que pega uma agência  específica pelo id
	//RETURN -> a agência específica ou mensagem de erro, caso o id não esteja registrado
	public Agencia getById(Long id) {
		return agenciarepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	//Definindo o método save que salva uma agência.
	public Agencia save(AgenciaDTO agenciaDTO) {
		
		Agencia agencia = new Agencia();
		
		agencia.setIdAgencia(agenciaDTO.getIdAgencia());
		agencia.setNomeDaAgencia(agenciaDTO.getNomeDaAgencia());
		agencia.setEndereco(agenciaDTO.getEndereco());
		agencia.setTelefone(agenciaDTO.getTelefone());
		return agenciarepository.save(agencia);
	}
	
	//Não colocamos delete na agência porque ela não pode ser deletada.
}
