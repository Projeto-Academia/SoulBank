package br.com.soulbank.service.exceptions;

public class ValorNuloException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValorNuloException(Object a) {
        super("Valor não pode ser nulo " + a);
    }
}

