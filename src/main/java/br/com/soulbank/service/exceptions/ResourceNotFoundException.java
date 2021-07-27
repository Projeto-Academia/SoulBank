package br.com.soulbank.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super ("Resource not found. Id: " + id);
    }
    
    public ResourceNotFoundException(Object id1, Object id2) {
        super ("Resource not found. Id: " + id1 + " e " + id2);
    }
}