package br.com.soulbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"br.com.soulbank.entity"})
@ComponentScan(basePackages = {"br.com.soulbank.*"}) // Anotação força a aplicação a reconhecer os controllers das classes
@EnableJpaRepositories(basePackages = {"br.com.soulbank.repository.*"}) // Anotação habilita o Repositório JPA das classes
@EnableTransactionManagement // Anotação habilita o spring a controlar as anotações na aplicação
public class SoulbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoulbankApplication.class, args);
	}

}
