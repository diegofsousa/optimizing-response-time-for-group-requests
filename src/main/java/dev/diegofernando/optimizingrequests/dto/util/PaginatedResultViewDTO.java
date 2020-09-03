package dev.diegofernando.optimizingrequests.dto.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

public class PaginatedResultViewDTO<DTO> {
	@JsonProperty(value = "total_count")
	private long totalCount;

	@JsonProperty
	private List<DTO> data = new ArrayList<>();

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<DTO> getData() {
		return data;
	}

	public void setData(List<DTO> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PaginatedResultViewDTO [totalCount=" + totalCount + ", " + (data != null ? "data=" + data : "") + "]";
	}

}
