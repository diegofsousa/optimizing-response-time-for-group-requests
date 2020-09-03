package dev.diegofernando.optimizingrequests.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dev.diegofernando.optimizingrequests.dto.util.ErrorFieldsViewDTO;
import dev.diegofernando.optimizingrequests.dto.util.MessageViewDTO;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		logger.error("[controller-dev]: ", ex);

		ErrorFieldsViewDTO errorFields = new ErrorFieldsViewDTO();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			MessageViewDTO messageError = getMessageError(error.getCode(), error.getField(), error.getDefaultMessage());
			errorFields.getErrorFields().add(messageError);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorFields);
	}

	private MessageViewDTO getMessageError(String code, String fieldName, String message) {
		switch (code) {
		case "NotNull":
			return new MessageViewDTO("Atributo '" + fieldName + "' foi esquecido", "error.path.missing");
		case "NotBlank":
		case "NotEmpty":
			return new MessageViewDTO("Atributo '" + fieldName + "' não pode ser vazio ou em branco",
					"error.param.empty");

		case "NotEmptyFields":
			return new MessageViewDTO(message, "error.list.invalid");

		case "Size":
			return new MessageViewDTO("Atributo '" + fieldName + "' tem tamanho " + message, "error.size");

		case "Pattern":
			return new MessageViewDTO(message, "error.pattern");

		default:
			return new MessageViewDTO("Não achou mensagens para seguinte chave '" + code + "'");
		}
	}

}
