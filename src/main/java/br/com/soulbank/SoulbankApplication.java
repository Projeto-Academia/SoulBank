package br.com.soulbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"br.com.soulbank.entity"})
public class SoulbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoulbankApplication.class, args);
	}

}
