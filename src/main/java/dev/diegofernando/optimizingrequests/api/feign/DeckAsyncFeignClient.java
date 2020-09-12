package dev.diegofernando.optimizingrequests.api.feign;

import java.util.concurrent.CompletableFuture;

import dev.diegofernando.optimizingrequests.dto.DeckViewDTO;
import feign.RequestLine;

/**
 * @author Diego Fernando
 * @since 03/09/2020
 */

public interface DeckAsyncFeignClient {

	@RequestLine("GET /deck/new/")
	CompletableFuture<DeckViewDTO> newDeck();
}
