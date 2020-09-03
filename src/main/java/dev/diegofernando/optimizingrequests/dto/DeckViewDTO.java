package dev.diegofernando.optimizingrequests.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

public class DeckViewDTO {
	private Boolean success;

	@JsonProperty(value = "deck_id")
	private String deckId;

	private Boolean shuffled;

	private Integer remaining;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getDeckId() {
		return deckId;
	}

	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}

	public Boolean getShuffled() {
		return shuffled;
	}

	public void setShuffled(Boolean shuffled) {
		this.shuffled = shuffled;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

	@Override
	public String toString() {
		return "DeckViewDTO [success=" + success + ", deckId=" + deckId + ", shuffled=" + shuffled + ", remaining="
				+ remaining + "]";
	}

}
