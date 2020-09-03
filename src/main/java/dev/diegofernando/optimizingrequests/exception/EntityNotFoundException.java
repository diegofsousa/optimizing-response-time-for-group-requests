package dev.diegofernando.optimizingrequests.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

public class EntityNotFoundException extends CommonsException {

	private static final long serialVersionUID = 5777553080388837214L;

	public EntityNotFoundException(String message) {
		this(HttpStatus.NOT_FOUND, message);
	}

	public EntityNotFoundException(String message, String key) {
		super(HttpStatus.NOT_FOUND, message, key);
	}

	public EntityNotFoundException(HttpStatus status, String message) {
		super(status, message);
	}
}
