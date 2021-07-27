package br.com.soulbank.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.soulbank.entity.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato, Long> {

	@Query("FROM Extrato g where g.conta.id = :IdContaCorrente")
	List<Extrato> findAllByIdConta(long IdContaCorrente);
}
