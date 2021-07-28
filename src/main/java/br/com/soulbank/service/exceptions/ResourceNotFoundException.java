package br.com.soulbank.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super ("ID não encontrado. Id: " + id);
    }
    
    public ResourceNotFoundException(Object id1, Object id2) {
        super ("Não existem contas com os IDs solicitaos. ID: " + id1 + " e " + id2);
    }
}