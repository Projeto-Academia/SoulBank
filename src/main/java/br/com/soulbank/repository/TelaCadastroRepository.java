package br.com.soulbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.soulbank.entity.Cliente;

@Repository

public interface TelaCadastroRepository extends JpaRepository<Cliente, Long> {

}