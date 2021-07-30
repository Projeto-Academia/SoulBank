package br.com.soulbank.resources.exceptions;

import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.soulbank.service.exceptions.DataBaseException;
import br.com.soulbank.service.exceptions.InvalidCPFException;
import br.com.soulbank.service.exceptions.ResourceNotFoundException;
import br.com.soulbank.service.exceptions.ValorNuloException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError moment = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(moment);
	}

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError moment = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(moment);

	}
	
	@ExceptionHandler(ValorNuloException.class)
	public ResponseEntity<StandardError> valorNulo(ValorNuloException e, HttpServletRequest request) {
		String error = "Valor não pode ser nulo.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError moment = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(moment);

	}
	
	@ExceptionHandler(InvalidCPFException.class)
	public ResponseEntity<StandardError> invalidCPF(InvalidCPFException e, HttpServletRequest request) {
		String error = "O CPF digitado é invalido.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError moment = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(moment);

	}

}