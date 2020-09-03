package dev.diegofernando.optimizingrequests.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.diegofernando.optimizingrequests.api.feign.DeckFeignClient;
import dev.diegofernando.optimizingrequests.dto.DeckViewDTO;
import dev.diegofernando.optimizingrequests.dto.util.MessageViewDTO;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

@Service
public class MainService {

	private static final Logger logger = LoggerFactory.getLogger(MainService.class);

	@Autowired
	private DeckFeignClient deckFeignClient;

	public MessageViewDTO getNormalRequests() {
		DeckViewDTO deck1 = deckFeignClient.newDeck();
		logger.info("[DECK] novo deck com chave " + deck1.getDeckId());
		DeckViewDTO deck2 = deckFeignClient.newDeck();
		logger.info("[DECK] novo deck com chave " + deck2.getDeckId());
		DeckViewDTO deck3 = deckFeignClient.newDeck();
		logger.info("[DECK] novo deck com chave " + deck3.getDeckId());

		return new MessageViewDTO("Requisições concluidas", "requests.normal.done");
	}

	public MessageViewDTO getCountdownRequests() {
		return new MessageViewDTO("Requisições concluidas", "requests.countdown.done");
	}

	public MessageViewDTO getFutureRequests() {
		return new MessageViewDTO("Requisições concluidas", "requests.future.done");
	}

}
