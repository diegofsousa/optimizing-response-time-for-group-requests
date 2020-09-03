package dev.diegofernando.optimizingrequests.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dev.diegofernando.optimizingrequests.dto.util.MessageViewDTO;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

public class CommonsException extends RuntimeException {

	private static final long serialVersionUID = 8108787508178666491L;

	private HttpStatus status;

	private String key;

	public CommonsException(String message) {
		this(HttpStatus.INTERNAL_SERVER_ERROR, message, "exception.commons.generic");
	}

	public CommonsException(String message, String key) {
		this(HttpStatus.INTERNAL_SERVER_ERROR, message, key);
	}

	public CommonsException(HttpStatus status, String message) {
		this(status, message, "exception.commons.generic");
	}

	public CommonsException(HttpStatus status, String message, String key) {
		super(message);
		this.status = status;
		this.key = key;
	}

	public CommonsException(HttpStatus status, String message, String key, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.key = key;
	}

	public ResponseEntity<MessageViewDTO> getMessageError() {
		return ResponseEntity.status(status).body(new MessageViewDTO(getMessage(), key));
	}

	public String getKey() {
		return key;
	}

}
