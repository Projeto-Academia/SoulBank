package br.com.soulbank.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

}