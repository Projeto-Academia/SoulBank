package br.com.soulbank.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soulbank.entity.ContaCorrente;
import br.com.soulbank.repository.ContaRepository;

@Service
public class ContaServico {

	@Autowired
	private ContaRepository contaRepository;
	
	private ContaCorrente contaCorrente;
	
	
	public List<ContaCorrente> findAll() {
		return contaRepository.findAll();
	}

	public ContaCorrente getById(Long id) {
		return contaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	public ContaCorrente save(ContaCorrente contaCorrente) {
		return contaRepository.save(contaCorrente);
	}
	
	public String Depositar(double valor) {
		contaCorrente.setSaldo(contaCorrente.getSaldo() + valor);
		return "Deposito efetuado com sucesso";
	}
	
	public String Sacar(double valor) {
		if (valor > contaCorrente.getSaldo()) {
			return "Saldo insuficiente para realizar a operação.";
		} else {
			contaCorrente.setSaldo(contaCorrente.getSaldo() - valor);
			return "Saque efetuado!";
		}
	}
	
	public String Transferir (ContaCorrente contaOrigem, ContaCorrente contaDestino, double valorTransfer) {
		if (contaOrigem.getSaldo() > valorTransfer) {
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTransfer);
			contaDestino.setSaldo(contaDestino.getSaldo() + valorTransfer);
			return "Transferência realizada com sucesso!";
		} else {
			return "Saldo insuficiente para realizar a operação.";
		}
	}
		
	public String RetornarSaldo (double saldoAtual) {
		return "O saldo atual é: " + contaCorrente.getSaldo();
		}
		
		
//ultima chave	
}
