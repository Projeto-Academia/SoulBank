package br.com.soulbank.service;

import java.beans.JavaBean;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.context.annotation.Configuration;
=======
>>>>>>> a99a32c4981f61e03ed8e1d786131555fb66fd63
import org.springframework.stereotype.Service;

import br.com.soulbank.entity.Agencia;
import br.com.soulbank.repository.AgenciaRepository;

@Service
public class AgenciaServico {
	
	@Autowired
	private AgenciaRepository agenciarepository;

	//Definindo o método findAll que lista todos os clientes na lista Cliente.
	//RETURN -> uma lista com todos os clientes registrados
	public List<Agencia> findAll() {
		return agenciarepository.findAll();
	}

	//Definindo o método getById que pega um cliente específico pelo id
	//RETURN -> o cliente específico ou mensagem de erro, caso o id não esteja registrado
	public Agencia getById(Long id) {
		return agenciarepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}

	//Definindo o método save que salva um cliente.
	public Agencia save(Agencia agencia) {
		return agenciarepository.save(agencia);
	}
	
	//Não colocamos delete na agência porque ela não pode ser deletada.
}
