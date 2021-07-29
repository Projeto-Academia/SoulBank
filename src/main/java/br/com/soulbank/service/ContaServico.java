package br.com.soulbank.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import br.com.soulbank.controller.dto.ContaCorrenteDTO;
import br.com.soulbank.entity.ContaCorrente;
import br.com.soulbank.entity.Extrato;
import br.com.soulbank.entity.Operacoes;
import br.com.soulbank.repository.ContaRepository;
import br.com.soulbank.repository.ExtratoRepository;
import br.com.soulbank.service.exceptions.ResourceNotFoundException;
import br.com.soulbank.service.exceptions.ValorNuloException;

@Service
public class ContaServico {

	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private ClienteServico cliente;
	@Autowired
	private AgenciaServico agencia;
	@Autowired
	private ExtratoRepository extratoRepository;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public List<ContaCorrente> findAll() {
		return contaRepository.findAll();
	}

	public ContaCorrente getById(Long id) {
		return contaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public ContaCorrente save(ContaCorrenteDTO contaCorrenteDTO) {

		try {
			ContaCorrente contaCorrente = new ContaCorrente();

			contaCorrente.setIdContaCorrente(contaCorrenteDTO.getIdContaCorrente());
			contaCorrente.setSaldo(contaCorrenteDTO.getSaldo());
			contaCorrente.setCliente(cliente.getById(contaCorrenteDTO.getIdCliente()));
			contaCorrente.setAgencia(agencia.getById(contaCorrenteDTO.getIdAgencia()));

			return contaRepository.save(contaCorrente);
		}
		catch(InvalidDataAccessApiUsageException e) {
			throw new ValorNuloException(contaCorrenteDTO);	
//			e.printStackTrace();
//			return null;
		}

	}

	public String Depositar(long idContaCorrente, double valor) {

		try {
			contaRepository.getById(idContaCorrente).setSaldo(contaRepository.getById(idContaCorrente).getSaldo() + valor);

			Extrato extrato = new Extrato();
			extrato.setConta(contaRepository.getById(idContaCorrente));
			extrato.setOperacoes(Operacoes.DEPOSITAR);
			extrato.setValorOperacao(valor);
			extrato.setDataHora(LocalDateTime.now().format(formatter));

			extratoRepository.save(extrato);

			return "Deposito efetuado com sucesso!";
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idContaCorrente);
		}

	}

	public String Sacar(long idContaCorrente, double valor) {

		try {
			if (valor > contaRepository.getById(idContaCorrente).getSaldo()) {
				return "Saldo insuficiente para realizar a operação.";
			} else {
				contaRepository.getById(idContaCorrente).setSaldo(contaRepository.getById(idContaCorrente).getSaldo() - valor);

				Extrato extrato = new Extrato();
				extrato.setConta(contaRepository.getById(idContaCorrente));
				extrato.setOperacoes(Operacoes.SACAR);
				extrato.setValorOperacao(valor);
				extrato.setDataHora(LocalDateTime.now().format(formatter));

				extratoRepository.save(extrato);

				return "Saque efetuado!";
			}
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idContaCorrente);
		}
	}

	public String Transferir (long idContaOrigem, long idContaDestino, double valorTransfer) {

		if (contaRepository.existsById(idContaOrigem) && contaRepository.existsById(idContaDestino)) {
			if (contaRepository.getById(idContaOrigem).getSaldo() > valorTransfer) {
				contaRepository.getById(idContaOrigem).setSaldo(contaRepository.getById(idContaOrigem).getSaldo() - valorTransfer);

				Extrato extrato = new Extrato();
				extrato.setConta(contaRepository.getById(idContaDestino));
				extrato.setOperacoes(Operacoes.TRANFERIR);
				extrato.setValorOperacao(valorTransfer);
				extrato.setDataHora(LocalDateTime.now().format(formatter));
				extratoRepository.save(extrato);

				contaRepository.getById(idContaDestino).setSaldo(contaRepository.getById(idContaDestino).getSaldo() + valorTransfer);

				return "Transferência realizada com sucesso!";

			} else {

				return "Saldo insuficiente para realizar a operação.";
			}
		}
		else {
			if (contaRepository.existsById(idContaOrigem)){
				throw new ResourceNotFoundException(idContaDestino);
			}
			else if (contaRepository.existsById(idContaDestino)) {
				throw new ResourceNotFoundException(idContaOrigem);
			}

			throw new ResourceNotFoundException(idContaOrigem, idContaDestino);
		}

	}


	public String RetornarSaldo (long idContaCorrente) {

		try {
			Extrato extrato = new Extrato();
			extrato.setConta(contaRepository.getById(idContaCorrente));
			extrato.setOperacoes(Operacoes.SALDOATUAL);
			extrato.setValorOperacao(contaRepository.getById(idContaCorrente).getSaldo());
			extrato.setDataHora(LocalDateTime.now().format(formatter));
			extratoRepository.save(extrato);

			return "O saldo atual é: " + contaRepository.getById(idContaCorrente).getSaldo();	
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idContaCorrente);
		}
		
	}

	//ultima chave	
}
