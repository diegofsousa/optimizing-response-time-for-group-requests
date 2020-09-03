package dev.diegofernando.optimizingrequests.dto.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

public final class MessageViewDTO {

	private String message;

	@JsonInclude(value = Include.NON_NULL)
	private String key;

	public MessageViewDTO(String message) {
		this(message, "generic.key");
	}

	public MessageViewDTO(String message, String key) {
		this.message = message;
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "MessageViewDTO [message=" + message + ", key=" + key + "]";
	}

}
