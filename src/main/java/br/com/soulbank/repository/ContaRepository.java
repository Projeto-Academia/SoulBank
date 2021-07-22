package br.com.soulbank.repository;
import br.com.soulbank.entity.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContaRepository extends JpaRepository<ContaCorrente, Long> {

}