package br.com.soulbank.repository;

import br.com.soulbank.entity.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Long> {

}
