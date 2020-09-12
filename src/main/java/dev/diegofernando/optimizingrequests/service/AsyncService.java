package dev.diegofernando.optimizingrequests.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import dev.diegofernando.optimizingrequests.api.feign.DeckFeignClient;
import dev.diegofernando.optimizingrequests.dto.DeckViewDTO;

/**
 * @author Diego Fernando
 * @since 11/09/2020
 */

@Service
public class AsyncService {

	@Autowired
	private DeckFeignClient deckFeignClient;

	@Async
	public CompletableFuture<DeckViewDTO> getAsyncDeck() {
		return CompletableFuture.completedFuture(deckFeignClient.newDeck());
	}
}
