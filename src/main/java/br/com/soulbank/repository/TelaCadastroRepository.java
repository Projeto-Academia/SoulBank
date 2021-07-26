package br.com.soulbank.repository;

import br.com.soulbank.controller.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.soulbank.entity.Cliente;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TelaCadastroRepository extends CrudRepository<ClienteDTO, Long> {

}