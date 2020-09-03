package dev.diegofernando.optimizingrequests.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.diegofernando.optimizingrequests.api.feign.DeckFeignClient;
import dev.diegofernando.optimizingrequests.api.feign.DeckFeignRetrofitClient;
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

	private int requestNumber = 5;

	public MessageViewDTO getNormalRequests() {

		for (int i = 0; i < requestNumber; i++) {
			DeckViewDTO deck1 = deckFeignClient.newDeck();
			logger.info("[DECK] novo deck com chave " + deck1.getDeckId());
		}

		return new MessageViewDTO("Requisições concluidas", "requests.normal.done");
	}

	public MessageViewDTO getCountdownRequests() {

		// final CountDownLatch allDecksFinished = new CountDownLatch(5);

		return new MessageViewDTO("Requisições concluidas", "requests.countdown.done");
	}

	public MessageViewDTO getFutureRequests() {

		Future<DeckViewDTO> deck1 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 1 ");
		Future<DeckViewDTO> deck2 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 2 ");
		Future<DeckViewDTO> deck3 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 3 ");
		Future<DeckViewDTO> deck4 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 4 ");
		Future<DeckViewDTO> deck5 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 5 ");
		Future<DeckViewDTO> deck6 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 6 ");
		Future<DeckViewDTO> deck7 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 7 ");
		Future<DeckViewDTO> deck8 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 8 ");
		Future<DeckViewDTO> deck9 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 9 ");
		Future<DeckViewDTO> deck10 = deckFeignClient.newFutureDeck();
		logger.info("[DECK] novo deck 10 ");

		try {
			logger.info("[DECK] novo deck com chave " + deck1.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck2.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck3.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck4.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck5.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck6.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck7.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck8.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck9.get().getDeckId());
			logger.info("[DECK] novo deck com chave " + deck10.get().getDeckId());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new MessageViewDTO("Requisições concluidas", "requests.future.done");
	}

	public MessageViewDTO getSpringAsync() throws InterruptedException, ExecutionException, TimeoutException {

		List<CompletableFuture<DeckViewDTO>> decks = new ArrayList<CompletableFuture<DeckViewDTO>>();

		for (int i = 0; i < requestNumber; i++) {
			var aux = i + 1;
			logger.info("[DECK] requisitando deck " + aux);
			decks.add(getAsyncDeck());
		}

		for (int i = 0; i < requestNumber; i++) {
			logger.info("[DECK] novo deck com chave " + decks.get(i).get().getDeckId());
		}

		return new MessageViewDTO("Requisições concluidas", "requests.future.done");
	}

	public MessageViewDTO getFeignRetrofitRequests() throws InterruptedException, ExecutionException, TimeoutException {
		DeckFeignRetrofitClient deckFeignRetrofit = AsyncFeign.asyncBuilder().decoder(new JacksonDecoder())
				.target(DeckFeignRetrofitClient.class, "https://deckofcardsapi.com/api");

		// ExecutorService executorService = Executors.newFixedThreadPool(40);

		List<CompletableFuture<DeckViewDTO>> decks = new ArrayList<CompletableFuture<DeckViewDTO>>();

		for (int i = 0; i < requestNumber; i++) {
			var aux = i + 1;
			logger.info("[DECK] requisitando deck " + aux);
			decks.add(deckFeignRetrofit.newDeck());
		}

		for (int i = 0; i < requestNumber; i++) {
			logger.info("[DECK] novo deck com chave " + decks.get(i).get().getDeckId());

		}
		// executorService.shutdown();
		return new MessageViewDTO("Requisições concluidas", "requests.retrofit.done");
	}

	// @Async
	public CompletableFuture<DeckViewDTO> getAsyncDeck() {
		return CompletableFuture.completedFuture(deckFeignClient.newDeck());
	}

}
