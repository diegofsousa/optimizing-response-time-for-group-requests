package dev.diegofernando.optimizingrequests.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.diegofernando.optimizingrequests.api.feign.DeckFeignClient;
import dev.diegofernando.optimizingrequests.api.feign.DeckAsyncFeignClient;
import dev.diegofernando.optimizingrequests.dto.DeckViewDTO;
import dev.diegofernando.optimizingrequests.dto.util.MessageViewDTO;
import feign.AsyncFeign;
import feign.jackson.JacksonDecoder;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

@Service
public class MainService {

	private static final Logger logger = LoggerFactory.getLogger(MainService.class);

	@Autowired
	private DeckFeignClient deckFeignClient;

	@Autowired
	private AsyncService asyncSevice;

	private int requestNumber = 70;

	public MessageViewDTO getNormalRequests() {

		for (int i = 0; i < requestNumber; i++) {
			DeckViewDTO deck1 = deckFeignClient.newDeck();
			logger.info("[DECK] new deck with key " + deck1.getDeckId());
		}

		return new MessageViewDTO("Completed requests", "requests.normal.done");
	}

	public MessageViewDTO getSpringAsync() throws InterruptedException, ExecutionException, TimeoutException {

		List<CompletableFuture<DeckViewDTO>> decks = new ArrayList<CompletableFuture<DeckViewDTO>>();

		for (int i = 0; i < requestNumber; i++) {
			var aux = i + 1;
			logger.info("[DECK] requesting deck " + aux);
			decks.add(asyncSevice.getAsyncDeck());
		}

		for (int i = 0; i < requestNumber; i++) {
			logger.info("[DECK] new deck with key " + decks.get(i).get().getDeckId());
		}

		return new MessageViewDTO("Completed requests", "requests.future.done");
	}

	public MessageViewDTO getAsyncFeignRequests() throws InterruptedException, ExecutionException, TimeoutException {
		DeckAsyncFeignClient deckAsyncFeign = AsyncFeign.asyncBuilder().decoder(new JacksonDecoder())
				.target(DeckAsyncFeignClient.class, "https://deckofcardsapi.com/api");

		List<CompletableFuture<DeckViewDTO>> decks = new ArrayList<CompletableFuture<DeckViewDTO>>();

		for (int i = 0; i < requestNumber; i++) {
			var aux = i + 1;
			logger.info("[DECK] requesting deck " + aux);
			decks.add(deckAsyncFeign.newDeck());
		}

		for (int i = 0; i < requestNumber; i++) {
			logger.info("[DECK] new deck with key " + decks.get(i).get().getDeckId());

		}

		return new MessageViewDTO("Completed requests", "requests.retrofit.done");
	}

//  TODO
//	public MessageViewDTO getCountdownRequests() {
//
//	}
}
