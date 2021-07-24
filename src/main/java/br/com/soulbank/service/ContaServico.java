package br.com.soulbank.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soulbank.controller.dto.ContaCorrenteDTO;
import br.com.soulbank.entity.ContaCorrente;
import br.com.soulbank.repository.ContaRepository;

@Service
public class ContaServico {

	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private ClienteServico cliente;
	@Autowired
	private AgenciaServico agencia;
	
	
	public List<ContaCorrente> findAll() {
		return contaRepository.findAll();
	}

	public ContaCorrente getById(Long id) {
		return contaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	public ContaCorrente save(ContaCorrenteDTO contaCorrenteDTO) {
		
		ContaCorrente contaCorrente = new ContaCorrente();
		
		contaCorrente.setIdContaCorrente(contaCorrenteDTO.getIdContaCorrente());
		contaCorrente.setSaldo(contaCorrenteDTO.getSaldo());
		contaCorrente.setCliente(cliente.getById(contaCorrenteDTO.getIdCliente()));
		contaCorrente.setAgencia(agencia.getById(contaCorrenteDTO.getIdAgencia()));
		
		return contaRepository.save(contaCorrente);
	}
	
	public String Depositar(long idConta, double valor) {
		contaRepository.getById(idConta).setSaldo(contaRepository.getById(idConta).getSaldo() + valor);
		return "Deposito efetuado com sucesso";
	}
	
	public String Sacar(long idContaCorrente, double valor) {
		if (valor > contaRepository.getById(idContaCorrente).getSaldo()) {
			return "Saldo insuficiente para realizar a operação.";
		} else {
			contaRepository.getById(idContaCorrente).setSaldo(contaRepository.getById(idContaCorrente).getSaldo() - valor);
			return "Saque efetuado!";
		}
	}
	
	public String Transferir (long idContaOrigem, long idContaDestino, double valorTransfer) {
		if (contaRepository.getById(idContaOrigem).getSaldo() > valorTransfer) {
			contaRepository.getById(idContaOrigem).setSaldo(contaRepository.getById(idContaOrigem).getSaldo() - valorTransfer);
			contaRepository.getById(idContaDestino).setSaldo(contaRepository.getById(idContaDestino).getSaldo() + valorTransfer);
			return "Transferência realizada com sucesso!";
		} else {
			return "Saldo insuficiente para realizar a operação.";
		}
	}
		
	public String RetornarSaldo (long idContaCorrente) {
		return "O saldo atual é: " + contaRepository.getById(idContaCorrente).getSaldo();
		}
		
		
//ultima chave	
}
