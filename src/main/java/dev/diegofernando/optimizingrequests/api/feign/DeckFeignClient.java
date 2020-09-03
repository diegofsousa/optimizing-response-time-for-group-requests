package dev.diegofernando.optimizingrequests.api.feign;

import java.util.concurrent.Future;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import dev.diegofernando.optimizingrequests.dto.DeckViewDTO;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

@FeignClient(name = "DeckFeignClient", url = "${external.deck.url}")
public interface DeckFeignClient {

	@GetMapping("/deck/new/")
	DeckViewDTO newDeck();

	@GetMapping("/deck/new/")
	Future<DeckViewDTO> newFutureDeck();

}
