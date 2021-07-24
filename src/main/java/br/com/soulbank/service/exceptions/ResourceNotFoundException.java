package br.com.soulbank.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    ResourceNotFoundException(Object id) {
        super ("Resource not found. Id: " + id);
    }
}