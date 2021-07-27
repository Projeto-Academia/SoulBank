package br.com.soulbank.repository;


import br.com.soulbank.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TelaCadastroRepository extends CrudRepository<Cliente, Long> {

}