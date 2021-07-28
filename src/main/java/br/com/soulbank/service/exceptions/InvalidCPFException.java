package br.com.soulbank.service.exceptions;

public class InvalidCPFException extends RuntimeException {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCPFException(Object cpf) {
        super("CPF inválido: " + cpf);
    }
	
}
