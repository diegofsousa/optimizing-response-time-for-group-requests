package dev.diegofernando.optimizingrequests.dto.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

public class ErrorFieldsViewDTO {

	private List<MessageViewDTO> errorFields = new ArrayList<>(3);

	public List<MessageViewDTO> getErrorFields() {
		return errorFields;
	}

	public void setErrorFields(List<MessageViewDTO> errorFields) {
		this.errorFields = errorFields;
	}

	@Override
	public String toString() {
		return "ErrorFieldsViewDTO [errorFields=" + errorFields + "]";
	}

}
